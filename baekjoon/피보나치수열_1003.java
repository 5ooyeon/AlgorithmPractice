package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수열_1003 {
    static Integer[][] cnt = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        cnt[0][0] = 1;
        cnt[0][1] = 0;

        cnt[1][0] = 0;
        cnt[1][1] = 1;

        for(int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(bf.readLine());
            System.out.println(fib(n)[0] +" "+fib(n)[1]);
        }
    }
    private static Integer[] fib(int n) {
        if(cnt[n][0] == null || cnt[n][1] == null) {
            cnt[n][0] = fib(n-1)[0] + fib(n-2)[0];
            cnt[n][1] = fib(n-1)[1] + fib(n-2)[1];
        }
        return cnt[n];
    }
}
