package baekjoon;

import java.util.*;
import java.io.*;

public class 스_스_스도쿠_4056 {
    static class Loc {
        int x, y;
        
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] sudoku;
    static Queue<Loc> ques;
    static Loc[] keys;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for(int tc = 1; tc <= t; tc++) {
            sudoku = new char[9][9];
            ques = new ArrayDeque<>();

            for(int i=0;i<9;i++) {
                sudoku[i] = bf.readLine().toCharArray();
                for(int j=0;j<9;j++) {
                    if(sudoku[i][j] == '0') {
                        ques.offer(new Loc(i, j));
                    }
                }
            }

            

        }

    }
}
