package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열_11722 {
    static int N, arr[], dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<N; i++) {
            dp[i] = 1;
            for (int j=0;j<i;j++) {
                if (arr[j]>arr[i] && dp[i]<dp[j]+1) {
                    dp[i] =dp[j]+ 1;
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N-1]);

    }
}
