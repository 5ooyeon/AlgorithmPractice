package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class n123더하기4_15989 {
    static long[] mm;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        mm = new long[10001];
        Arrays.fill(mm, 1);
        // mm[1] = 0;

        // mm[4] = mm[1] + mm[4]
        // mm[4] = mm[2] + mm[4]

        for(int i=3;i<=n;i++) {
            mm[i] += mm[i-2];
        }

        for(int i=4;i<=n;i++) {
            mm[i] += mm[i-3];
        }

        System.out.println(mm[n]);
    }

    private static long dp(int n) {

        if(mm[n] != -1) {
            return mm[n];
        }

        long sum = 0;
        for(int i=n-1;i>0;i--) {
            sum += dp(i);
        }

        return mm[n] = sum;
        // return dp(n-1) + ... + dp(1)
    }
}
