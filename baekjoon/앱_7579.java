package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 앱_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2], dp = new int[N][100001];
        int ans = Integer.MAX_VALUE;
        st = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st2.nextToken());
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<=10000;j++) {
                if(i==0) {
                    if(j>=arr[i][1]) {
                        dp[i][j] = arr[i][0];
                    }
                } else {
                    if(j>=arr[i][1]) {
                        dp[i][j] = Math.max(dp[i-1][j-arr[i][1]] + arr[i][0], dp[i-1][j]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                if(dp[i][j] >= M) {
                    ans = Math.min(ans, j);
                }
            }
        }
        System.out.println(ans);
    }
}
