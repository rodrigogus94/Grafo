
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodri
 */
public class Teste {

    public static void main(String[] args) throws VerticeException, ArestaException {

        Grafo g = new Grafo();
        BuscaLargura bl = new BuscaLargura();
        Scanner scanner = new Scanner(System.in);
        int cont=0;
        g.adicionarVertice(0);
        cont++;
        g.adicionarVertice(1);
        cont++;
        g.adicionarVertice(2);
        cont++;
        g.adicionarVertice(3);
        cont++;
        g.adicionarVertice(4);
        cont++;
        
        int[][] matriz = new int[cont][cont];

        g.adicionarAresta(0, 1);
        g.adicionarAresta(1, 2);
        g.adicionarAresta(2, 3);
        g.adicionarAresta(2, 0);
        g.adicionarAresta(3, 1);

        g.mostrarMatriz(0, 1);
        g.mostrarMatriz(1, 2);
        g.mostrarMatriz(2, 3);
        g.mostrarMatriz(2, 1);
        g.mostrarMatriz(3, 1);
        
     
        bl.executar(g);

        System.out.println(g);

    }

}
