package swea;

import java.io.*;
import java.util.*;

public class 보급로 {

    static int n, arr[][], dp[][];
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for(int tc = 1; tc <= t; tc++) {
            sb.append("#"+tc+" ");
            n = Integer.parseInt(bf.readLine());
            arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                String[] te = bf.readLine().split("");
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(te[j]);
                }
            }

            dp = new int[n][n];
            for(int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE); // 초기값을 최대값으로 설정
            }
            dp[0][0] = arr[0][0];
            save(0, 0);

            sb.append(dp[n-1][n-1]+"\n");
        }
        System.out.println(sb);
    }

    static void save(int x, int y) {
        for(int i=0;i<4;i++) {
            try {
                if(dp[x+dx[i]][y+dy[i]] > dp[x][y]+arr[x+dx[i]][y+dy[i]]) {
                    dp[x+dx[i]][y+dy[i]] = dp[x][y]+arr[x+dx[i]][y+dy[i]];
                    save(x+dx[i], y+dy[i]);
                }
            } catch (Exception e) {
            }
        }
    }
}
