package baekjoon;

import java.io.*;
import java.util.*;

public class AlmostKIncreasingSubsequence_17243 {
    static final int MAXN = 501;

    static int N, K;
    static int[] a = new int[MAXN];
    static int[][] cache = new int[MAXN][MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < MAXN; ++i) {
            for (int j = 0; j < MAXN; ++j) {
                cache[i][j] = -1;
            }
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; ++i) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        if(N == 1) {
            System.out.println(N-K); return;
        }
        System.out.println(getMaxLen(0, 0));
    }

    static int getMaxLen(int index, int k) {
        if (index >= N || k > K)
            return 0;

        if (cache[index][k] != -1)
            return cache[index][k];

        int ret = 1;
        for (int next = index + 1; next < N; ++next) {
            if (a[index] <= a[next])
                ret = Math.max(ret, 1 + getMaxLen(next, k));
            else if (a[index] > a[next])
                ret = Math.max(ret, 1 + getMaxLen(next, k + 1));
        }
        cache[index][k] = ret;
        return ret;
    }
}
