package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이판다_1937 {
    static int n, arr[][], dp[][], dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 1;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                ans = Math.max(ans, dp(i, j));
            }
        }

        System.out.println(ans);
        
    }
    private static int dp(int i, int j) {
        if(dp[i][j] != 0) return dp[i][j];

        dp[i][j] = 1;

        for(int idx = 0;idx < 4; idx++) {
            int x = i+dx[idx], y = j+dy[idx];
            if(isInRange(x, y) && arr[i][j] < arr[x][y]) {
                dp[i][j] = Math.max(dp[i][j], dp(x, y)+1);
            }
        }

        return dp[i][j];
    }
    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
