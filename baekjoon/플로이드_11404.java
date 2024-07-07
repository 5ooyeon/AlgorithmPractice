package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플로이드_11404
 */
public class 플로이드_11404 {
    static int N, M, arr[][],INF = Integer.MAX_VALUE/3;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                arr[i][j] = INF;
            }
        }
        M = Integer.parseInt(bf.readLine());
        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1,
            b = Integer.parseInt(st.nextToken())-1,
            c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(c, arr[a][b]);
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]); 
                }
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                sb.append(arr[i][j] == INF || i==j ? "0 " : arr[i][j]+ " " );
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}