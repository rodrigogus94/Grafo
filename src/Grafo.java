
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafo {

    private List<Vertice> vertices;

    private List<Aresta> arestas;

    private List<Vertice> corte;

    int contVertices = 0;

    public Grafo() {
        vertices = new ArrayList<Vertice>();
        arestas = new ArrayList<Aresta>();
    }

    public int pesoNaoDirecionado(Vertice u, Vertice v) {
        Aresta a = obterArestaNaoDirecionada(u, v);
        if (a != null) {
            return a.getCusto();
        } else {
            return -1;
        }
    }

    public Aresta obterAresta(Vertice u, Vertice v) {
        for (Aresta a : arestas) {
            if (a.getOrigem().equals(u) && a.getDestino().equals(v)) {
                return a;
            }
        }

        return null;
    }

    public ArrayList<Aresta> obterArestas(Vertice u) {
        ArrayList<Aresta> retorno = new ArrayList<Aresta>();
        for (Aresta a : arestas) {
            if ((a.getOrigem().equals(u) || a.getDestino().equals(u))) {
                retorno.add(a);
            }
        }

        return retorno;
    }

    public Aresta obterArestaNaoDirecionada(Vertice u, Vertice v) {
        for (Aresta a : arestas) {
            if ((a.getOrigem().equals(u) && a.getDestino().equals(v))
                    || (a.getDestino().equals(u) && a.getOrigem().equals(v))) {
                return a;
            }
        }

        return null;
    }

    public void adicionarVertice(int id) throws VerticeException {

        for (Vertice v : vertices) {
            contVertices++;
            if (v.getId() == id) {
                throw new VerticeException("Vertice já existe: " + id);
            }
        }

        vertices.add(new Vertice(id));
    }

    public Vertice obterVertice(int id) {
        Vertice retorno = null;
        for (Vertice v : vertices) {
            if (v.getId() == id) {
                retorno = v;
                break;
            }
        }

        return retorno;
    }

    public void adicionarAresta(int origem, int destino) throws VerticeException, ArestaException {
        Vertice vOrigem = obterVertice(origem);
        Vertice vDestino = obterVertice(destino);
        checaVertices(origem, destino, vOrigem, vDestino);

        Aresta aresta = new Aresta();
        aresta.setOrigem(vOrigem);
        aresta.setDestino(vDestino);
        arestas.add(aresta);
    }

    private void checaVertices(int origem, int destino, Vertice vOrigem, Vertice vDestino) throws VerticeException, ArestaException {
        if (origem < 0 || vOrigem == null) {
            throw new VerticeException("Vertice origem invalido: " + origem);
        }

        if (destino < 0 || vDestino == null) {
            throw new VerticeException("Vertice destino invalido: " + destino);
        }

        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().getId() == origem
                    && aresta.getDestino().getId() == destino) {
                throw new ArestaException("Aresta já existe: (" + origem + "," + destino + ")");
            }
        }
    }

    public void adicionarAresta(int origem, int destino, int custo) throws VerticeException, ArestaException {
        Vertice vOrigem = obterVertice(origem);
        Vertice vDestino = obterVertice(destino);
        checaVertices(origem, destino, vOrigem, vDestino);

        Aresta aresta = new Aresta();
        aresta.setOrigem(vOrigem);
        aresta.setDestino(vDestino);
        aresta.setCusto(custo);
        arestas.add(aresta);
    }

    public List<Vertice> adjacentesNaoDirecionados(Vertice vertice) {
        ArrayList<Vertice> adjacentes = new ArrayList<Vertice>();

        for (Aresta a : arestas) {
            Vertice origem = a.getOrigem();
            Vertice destino = a.getDestino();
            Vertice novo = null;

            if (vertice.equals(origem)) {
                novo = destino;
            } else if (vertice.equals(destino)) {
                novo = origem;
            }

            if (vertice.equals(origem) || vertice.equals(destino)
                    && !adjacentes.contains(novo)) {
                adjacentes.add(novo);
            }
        }

        return adjacentes;
    }

    public List<Vertice> adjacentes(Vertice v) {
        ArrayList<Vertice> retorno = new ArrayList<Vertice>();

        for (Aresta a : arestas) {
            if (a.getOrigem().equals(v)) {
                retorno.add(a.getDestino());
            }
        }

        return retorno;
    }

    public List<Vertice> getVertices() {
        Collections.sort(vertices);
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }

    public List<Aresta> getArestas() {
        Collections.sort(arestas);
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("G = { \nV{");
        for (int i = 0; i < vertices.size(); i++) {
            builder.append(vertices.get(i).toString());
            if (i < vertices.size() - 1) {
                builder.append(", ");
            }
        }

        builder.append("}\n");
        builder.append("A{");
        for (int i = 0; i < arestas.size(); i++) {
            builder.append(arestas.get(i).toString());
            if (i < arestas.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("}\n}");

        return builder.toString();
    }

    public void mostrarMatriz(int origem, int destino) {
        int tamanho = contVertices;
        int[][] coluna = new int[tamanho][tamanho];
        int[][] linha = new int[tamanho][tamanho];
        int X = origem, Y = destino;
        String mos = "", linhaCont = "", mosO="", mosD="";
        for (int i = 0; i < linha.length; i++) {
            for (int j = 0; j < coluna.length; j++) {
                if (j == 0) {
                    if (X == i && Y == j) {
                        mos += (i + " |") + "   " + 1 + ",";
                    } else {
                        mos += (i + " |") + "   " + 0 + ",";
                    }
                } else {
                    if (X == i && Y == j) {
                        mos += "  " + 1 + ",";
                    } else {
                        mos += "  " + 0 + ",";
                    }
                    if (j == tamanho - 1) {
                        mos += "\n";
                    }

                }
            }
        }
        for (int i = 0; i < tamanho; i++) {
            linhaCont += "  | " + i;

        }
        System.out.println(linhaCont);
        System.out.println(mos);
        
        for (int i = 0; i < linha.length; i++) {
            for (int j = 0; j < coluna.length; j++) {
               mosO += "{ " + X + ", " + "}"; 
               mosD += "{ " + Y + ", " + "}"; 
            }
            
        }
        
         System.out.println(mosO);
         System.out.println(mosD);

    }

    public ArrayList<Aresta> obterAgmNaoDirecionadaPrim() {
        ArrayList<Aresta> arestas = new ArrayList<Aresta>();
        for (Vertice v : vertices) {
            Aresta a = obterArestaNaoDirecionada(v, v.getPredecessor());
            if (a != null) {
                arestas.add(a);
            }
        }
        return arestas;
    }

    public List<Vertice> getCorte() {
        return corte;
    }

    public void setCorte(List<Vertice> corte) {
        this.corte = corte;
    }

    public Aresta obterArestaSegura() {
        Aresta segura = null;
        for (Aresta a : arestas) {
            if ((corte.contains(a.getOrigem()) && !corte.contains(a.getDestino()))
                    || (corte.contains(a.getDestino()) && !corte.contains(a.getOrigem()))) {
                if (segura == null || a.getCusto() < segura.getCusto()) {
                    segura = a;
                }
            }
        }
        return segura;
    }
}
