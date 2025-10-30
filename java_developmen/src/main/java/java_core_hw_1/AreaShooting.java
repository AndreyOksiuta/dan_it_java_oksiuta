package java_core_hw_1;

import java.util.Random;
import java.util.Scanner;

public class AreaShooting {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[][] board = new String[5][5];
        int borderOfBoardMin = 1;
        int borderOfBoardColumMax = board.length;
        int borderOfBoardRowMax = board[0].length;
        System.out.println("All Set. Get ready to rumble!");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
            }
        }
        int rowRandom = (random.nextInt(5)) + 1;
        int columnRandom = (random.nextInt(5)) + 1;
        System.out.println("RANDOM-" + columnRandom + " " + rowRandom);
        while (true) {
            System.out.println("0 | 1 | 2 | 3 | 4 | 5 |");
            for (int i = 0; i < board.length; i++) {
                System.out.print(i + 1 + "| ");
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " | ");
                }
                System.out.println();
            }
            System.out.println("Input number colum from 1 to 5");
            int column = scanner.nextInt();
            System.out.println("Input number row from 1 to 5");
            int row = scanner.nextInt();
            if (column > borderOfBoardColumMax || column < borderOfBoardMin
                    || row > borderOfBoardRowMax || row < borderOfBoardMin) {
                System.out.println("Invalid input! Try again!");
            } else {
                if (row == rowRandom && column == columnRandom) {
                    board[row - 1][column - 1] = "X";
                    System.out.println("You have won!");
                    System.out.println("0 | 1 | 2 | 3 | 4 | 5 |");
                    for (int i = 0; i < board.length; i++) {
                        System.out.print(i + 1 + "| ");
                        for (int j = 0; j < board[i].length; j++) {
                            System.out.print(board[i][j] + " | ");
                        }
                        System.out.println();
                    }
                    break;
                } else {
                    board[row - 1][column - 1] = "*";
                    System.out.println("Try again!");
                }
            }
        }
    }
}
