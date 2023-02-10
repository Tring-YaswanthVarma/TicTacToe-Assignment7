package org.example;

import java.util.Scanner;

public class TicTacToe {
    public int checkHorizontal(char[] a) {
        int flag = 0;
        for (int i = 1; i <= 2; i += 1) {
            if (a[i] != a[i - 1]) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public int checkVertical(int columnIndex, char[][] a) {
        int flag = 0;
        for (int i = 1; i <= 2; i += 1) {
            if (a[i][columnIndex] != a[i - 1][columnIndex]) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public int checkLeftDiagonal(int rowIndex, int columnIndex, char[][] a) {
        int flag = 0;
        for (int i = 1; i <= 2; i += 1, rowIndex -= 1, columnIndex += 1) {
            if (a[rowIndex][columnIndex] != a[rowIndex - 1][columnIndex + 1]) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public int checkRightDiagonal(char[][] a) {
        int flag = 0;
        for (int i = 1; i <= 2; i += 1) {
            if (a[i][i] != a[i - 1][i - 1]) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    public int checkWin(int rowIndex, int columnIndex, char[][] a) {
        int hor;
        int ver;
        int rDig = -1;
        int lDig = -1;
        hor = checkHorizontal(a[rowIndex]);
        ver = checkVertical(columnIndex, a);
        if (rowIndex == 1 && columnIndex == 1) {
            rDig = checkRightDiagonal(a);
            lDig = checkLeftDiagonal(2, 0, a);
        } else if (rowIndex == columnIndex) {
            rDig = checkRightDiagonal(a);
        } else {
            lDig = checkLeftDiagonal(2, 0, a);
        }
        if (hor == 0 || ver == 0 || rDig == 0 || lDig == 0) {
            return 0;
        }
        return 1;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] a = new char[3][3];
        TicTacToe t = new TicTacToe();
        char p1 = 'x';
        char p2 = 'O';
        char p;
        int rowIndex;
        int columnIndex;
        int count = 0;
        while (count < 9) {
            if (count % 2 == 0)
                p = p1;
            else
                p = p2;
            System.out.println("  0 1 2");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            boolean player = true;
            while(player){
                System.out.println("Player " + p + " turn : ");
                System.out.println("Enter row Index : ");
                rowIndex = sc.nextInt();
                System.out.println("Enter column Index : ");
                columnIndex = sc.nextInt();
                if (a[rowIndex][columnIndex] == 0)
                    player = false;
                else
                    continue;
                a[rowIndex][columnIndex] = p;
                if (t.checkWin(rowIndex, columnIndex, a) == 0) {
                    System.out.println("Player "+p+" Win");
                    count = 10;
                    break;
                } else {
                    System.out.println("continue---------");
                }
            }
            count += 1;
        }
    }
}
