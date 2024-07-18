package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전1_2293 {
    static int N, K, arr[], dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        arr = new int[N];
        int idx = 0;

        for(int i=0;i<N;i++) {
            arr[idx] = Integer.parseInt(bf.readLine());
            if(arr[idx] <= K) idx++;
        }

        arr = Arrays.copyOf(arr, idx);
        Arrays.sort(arr);

        dp = new int[K+1];
        dp[0] = 1;
        for(int i=0;i<idx;i++) {
            for(int j=arr[i];j<=K;j++) {
                dp[j] += dp[j-arr[i]];
            }
        }

        System.out.println(dp[K]);

    }
}
