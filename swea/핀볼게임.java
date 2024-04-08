package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 핀볼게임 {
    static int N, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <= t; tc++) {
            sb.append("#"+tc+" ");
            N = Integer.parseInt(bf.readLine());
            arr = new int[N][N];
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
        }
    }
}
