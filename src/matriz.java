
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodri
 */
public class matriz {

    public static void main(String[] args) {

        //int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamnaho da matriz"));
        int[][] coluna = new int[2][2];
        int[][] linha = new int[2][2];
        int[][] matriz = new int[2][2];
        int cont = 0, contM = 0;
        String mos = "", mosA = "", mosN = "", linhaCont = "";
        boolean m = false;
        //int X = Integer.parseInt(JOptionPane.showInputDialog("Digite a posicao x"));
        //int Y = Integer.parseInt(JOptionPane.showInputDialog("Digite a posicao y"));

        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < linha.length; i++) {
            for (int j = 0; j < coluna.length; j++) {
                System.out.printf("Insira o elemento M[%d][%d]: ", i + 1, j + 1);
                matriz[i][j] = entrada.nextInt();
            }
        }

        /* for (int i = 0; i < coluna.length; i++) {
            for (int j = 0; j < coluna[i].length; j++) {

                if (j == 0) {
                    if (X == j && Y == i) {
                        mos += (i + " |") + "   " + 1 + ",";
                    } else {
                        mos += (i + " |") + "   " + cont + ",";
                    }

                    // cont++;
                } else {
                    if (X == j && Y == i) {
                        mos += "  " + 1 + ",";
                    } else {
                        mos += "  " + cont + ",";
                    }
                    //cont++;
                }
                if (j == 3) {
                    mos += "\n";
                }

            }

        }*/
        contM++;

        for (int i = 0; i < 2; i++) {
            linhaCont += "  | " + i;

        }
        System.out.println(linhaCont);
        for (int i = 0; i < linha.length; i++) {
            for (int j = 0; j < coluna.length; j++) {

                System.out.printf("\t %d \t", matriz[i][j] + (i + " |") + "   " + 1 + ",");
            }
            System.out.println();
        }

        // System.out.println(mos);
        /* int[][] matriz = new int[3][2];

        Scanner entrada = new Scanner(System.in);
        System.out.println("Matriz M[3][2]\n");

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 2; coluna++) {
                System.out.printf("Insira o elemento M[%d][%d]: ", linha + 1, coluna + 1);
                matriz[linha][coluna] = entrada.nextInt();
            }
        }

        System.out.println("\nA Matriz ficou: \n");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 2; coluna++) {
                System.out.printf("\t %d \t", matriz[linha][coluna]);
            }
            System.out.println();
        }*/
    }

}
