package baekjoon;

import java.io.*;
import java.util.Arrays;

public class 동전2_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]),
        k = Integer.parseInt(inputs[1]);

        int[] coins = new int[n];
        for(int i=0;i<n;i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for(int i=0;i<n;i++) {
            for(int j=coins[i];j<=k;j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }

        System.out.println(dp[k] == 987654321 ? -1 : dp[k]);

    }
}
