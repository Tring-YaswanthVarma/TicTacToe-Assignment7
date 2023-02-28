package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Main {

    public static void print(char[][] a) {
        Logger log = Logger.getLogger("com.api.jar");
        String s;

        log.info("  0 1 2\n");
        for (int i = 0; i < 3; i++) {
            s = i + " ";
            log.info(s);
            for (int j = 0; j < 3; j++) {
                s = a[i][j] + " ";
                log.info(s);
            }
            log.info("\n");
        }
    }
    public static void main(String[] args) {
        Logger log = Logger.getLogger("com.api.jar");
        String s;
        Scanner sc = new Scanner(System.in);

        char[][] a = new char[3][3];
        TicTacToe t = new TicTacToe();
        char p1 = 'x';
        char p2 = 'O';
        char p;
        int rowIndex = -1;
        int columnIndex = -1;
        int count = 0;
        while (count < 9) {
            p = count % 2 == 0 ? p1 : p2;
            print(a);
            boolean player = true;
            while (player) {
                s = "Player " + p + " turn : ";
                log.info(s);
                try {

                    log.info("Enter row Index and column index: ");
                    rowIndex = sc.nextInt();
                    columnIndex = sc.nextInt();
                    if (a[rowIndex][columnIndex] == 0)
                        player = false;
                    else
                        log.info("That position is already occupied. Try again");
                } catch (Exception e){
                    log.info("Only enter a number less than 3, Since this is a 3x3 grid.");
                }

            }
            a[rowIndex][columnIndex] = p;
            if (t.checkWin(rowIndex, columnIndex, a) == 0) {
                s = "Player " + p + " Win";
                log.info(s);
                break;
            }

            count += 1;
        }
    }
}



