package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 요리사 {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int tc= 1; tc <= T; tc++) {
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
        }
    }
}
