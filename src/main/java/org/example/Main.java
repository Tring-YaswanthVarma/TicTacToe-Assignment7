package org.example;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class Main {

    public static void print(char[][] a) {
        System.out.println("  0 1 2\n");
        for (int i = 0; i < 3; i++) {
//            s = i + " ";
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
//                s = a[i][j] + " ";
                System.out.print(a[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger("com.api.jar");
//        System.out.println("Hello how are you :");
        char[][] a = new char[3][3];
        TicTacToe t = new TicTacToe();
        char p1 = 'x';
        char p2 = 'O';
        char p;
        int rowIndex = -1;
        int columnIndex = -1;
        int count = 0;
        while (count < 9) {
            p = p2;
            if (count % 2 == 0)
                p = p1;
            String s;
            print(a);
            boolean player = true;
            while (player) {
                System.out.println("Player " + p + " turn : ");
                try {

                    System.out.println("Enter row Index and column index: ");
                    rowIndex = sc.nextInt();
                    columnIndex = sc.nextInt();
                    if (a[rowIndex][columnIndex] == 0)
                        player = false;
                    else
                        System.out.println("That position is already occupied. Try again");
                } catch (InputMismatchException e) {
                    System.out.println("Cannot enter alphabets. Enter a number from 0, 1 and 2.");
                    sc.nextLine();
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Enter a number less than 3, Since this is a 3x3 grid.");
                }

            }
            a[rowIndex][columnIndex] = p;
            if (t.checkWin(rowIndex, columnIndex, a) == 0) {
                System.out.println("Player " + p + " Win");
                break;
            }
//            System.out.println("continue---------");
            count += 1;
        }
    }
}
