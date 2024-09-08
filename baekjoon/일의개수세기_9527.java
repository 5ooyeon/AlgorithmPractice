package baekjoon;

import java.io.*;
import java.util.*;

public class 일의개수세기_9527 {
    static long[] DP = new long[55];
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long N = Long.parseLong(st.nextToken()), M = Long.parseLong(st.nextToken());

        DP[0] = 1;
        for(int i=1;i<55;i++) {
            DP[i] = (DP[i-1] << 1) + (1L << i);
        }

        long result = calOne(M) - calOne(N-1);
        System.out.print(result);
    }

    static long calOne(long N) {
        long cntOne = N & 1;
        int size = (int) (Math.log(N)/Math.log(2));
        for(int i=size;i>0;i--) {
            if((N & (1L<<i)) != 0L) {
                cntOne += DP[i-1] +(N - (1L<<i) + 1);
                N -= (1L << i);
            }
        }
        return cntOne;
    }

}