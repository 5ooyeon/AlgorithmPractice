package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알고스팟_1261 {
    static int N, M, cnt[][];
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        M = Integer.parseInt(input[0]); N = Integer.parseInt(input[1]);
        arr = new char[N][M]; cnt = new int[N][M];

        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
            for(int j=0;j<M;j++) {
                cnt[i][j] = Integer.MAX_VALUE;
            }
        }

        

    }
}
