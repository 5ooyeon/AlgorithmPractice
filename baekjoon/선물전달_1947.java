package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 선물전달_1947 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		long dp[] = new long[N + 1];
        int mod = 1000000000;
		if (N == 1)
			System.out.println(0);
		else {
			dp[1] = 0;
			dp[2] = 1;
			for (int i=3;i<=N;i++) {
				dp[i] = ((dp[i-1] + dp[i-2]) % mod) * (i-1) % mod;
			}
			System.out.println(dp[N]);
		}
    }
}
