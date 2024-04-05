package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이동하기_11048 {
    static int N, M, arr[][];
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        

    }
}
