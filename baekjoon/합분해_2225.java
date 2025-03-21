package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해_2225 {

    static long mm[][], mod = 1_000_000_000;

    static long dp(int n, int k) {
        if(mm[n][k] != 0) return mm[n][k];
        if (k == 1) return 1L;
        if (n == 0) return 1L;
        return mm[n][k] = dp(n-1, k)%mod + dp(n, k-1)%mod;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        mm = new long[N+1][K+1];

        System.out.println(dp(N, K)%mod);


        // dp(n, k) = dp(n, k-1) + dp(n-1, k)
        // dp(n, k-1): 가장 앞의 숫자를 0으로 고정시켰을 때
        // n=4, k=2 일 때, dp(4, 1) = (0, 4) 

        // dp(n-1, k): 가장 앞의 숫자를 -1 했을 때
        // n=4, k=2 일 때, dp(3, 2) = (0, 3) (1, 2) (2, 1) (3, 0) => (1, 3) (2, 2) (3, 1) (4, 0)

        // 6 4 라면
        /*
         * 0 0 0 0 0 6
         * 0 0 0 0 1 5
         * 0 0 0 0 6 0 -> 7개
         * 두 자리수: n 일 때 n+1개
         * 
         * 0 0 0 1 0 5
         * 0 0 0 1 5 0 -> 6개
         * 
         * 0 0 0 2 0 4
         * 0 0 0 2 4 0 -> 5개
         * 
         * 0 0 0 3     -> 4개
         * 
         * 0 0 0 4     -> 3개
         * 
         * 0 0 0 5     -> 2개
         * 
         * 0 0 0 6     -> 1개
         * 
         * 세 자릿수: n 일 때 (n+1)*n/2
         * 
         * 네 자릿수: n 일 때, 
         * 
         * 0 0 1 0 0 5
         * 0 0 2 0 0 4
         * 3 3
         * 4 2
         * 5 1
         */

        
    }
}
