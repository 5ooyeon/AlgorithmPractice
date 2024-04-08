package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 퇴사2_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int ans = getMaxProfit(N, arr);
        System.out.println(ans);
    }

    static int getMaxProfit(int N, int[][] arr) {
        int[] dp = new int[N + 1]; // DP 테이블
        int maxProfit = 0;

        for (int i = 0; i < N; i++) {
            int nextDay = i + arr[i][0];
            if (nextDay <= N) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + arr[i][1]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]); // 다음 날로 넘어갈 때의 최대 이익 갱신
            maxProfit = Math.max(maxProfit, dp[i + 1]); // 최대 이익 갱신
            System.out.println(Arrays.toString(dp)+i+" "+nextDay);
        }

        return maxProfit;
    }
}
