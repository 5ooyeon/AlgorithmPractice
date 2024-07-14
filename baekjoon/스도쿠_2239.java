package baekjoon;

import java.io.*;

public class 스도쿠_2239 {
    static char[][] arr = new char[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        solveSudoku(0, 0);
    }

    static boolean solveSudoku(int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }

        if (row == 9) {
            printBoard();
            return true;
        }

        if (arr[row][col] != '0') {
            return solveSudoku(row, col + 1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(row, col, num)) {
                arr[row][col] = num;

                if (solveSudoku(row, col + 1)) {
                    return true;
                }

                arr[row][col] = '0';
            }
        }

        return false;
    }

    static boolean isValid(int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == num || arr[i][col] == num) {
                return false;
            }
        }
        
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
