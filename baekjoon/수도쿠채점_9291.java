package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 수도쿠채점_9291 {
    static int[][] sudoku = new int[9][9];
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= N; tc++) {
            sb.append("CASE "+tc+": ");
            Boolean isIncorrect = false;
            for(int i=0;i<9;i++) {

                st = new StringTokenizer(bf.readLine());
                set = new HashSet<>();
                for(int j=0;j<9;j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                    set.add(sudoku[i][j]);
                }
                if(set.size()!=9) {
                    isIncorrect = true;
                }
            }
            if(tc!=N) {
                bf.readLine();
            }
            if(!isIncorrect) {
                for(int i=0;i<3;i++) {
                    for(int j=0;j<3;j++) {
                        set = new HashSet<>();
                        set.add(sudoku[3*i][3*j]);
                        set.add(sudoku[3*i+1][3*j]);
                        set.add(sudoku[3*i+2][3*j]);
                        set.add(sudoku[3*i][3*j+1]);
                        set.add(sudoku[3*i+1][3*j+1]);
                        set.add(sudoku[3*i+2][3*j+1]);
                        set.add(sudoku[3*i][3*j+2]);
                        set.add(sudoku[3*i+1][3*j+2]);
                        set.add(sudoku[3*i+2][3*j+2]);
                        if(set.size()!=9) {
                            isIncorrect = true; break;
                        }
                    }
                }
            }
            if(!isIncorrect) {
                for(int i=0;i<9;i++) {
                    set = new HashSet<>();
                    for(int j=0;j<9;j++) {
                        set.add(sudoku[j][i]);
                    }
                    if(set.size()!=9) {
                        isIncorrect = true; break;
                    }
                }
            }
            if(isIncorrect) {
                sb.append("IN");
            }
            sb.append("CORRECT\n");

        }
        System.out.println(sb.toString());
    }
}
