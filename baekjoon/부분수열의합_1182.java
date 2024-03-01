package baekjoon;

import java.io.*;
import java.util.*;

public class 부분수열의합_1182 {
    static int n, arr[], s, ansCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // ----
        ansCnt = 0; // 정답 초기화

        for (int i = 0; i < n; i++) {
            dfs(arr[i], i);
        }

        System.out.println(ansCnt);
    }

    static void dfs(int hap, int idx) {
        if (hap == s) {
            ansCnt++;
        }
        for (int i = idx + 1; i < n; i++) {
            if (arr[i] > 0) {
                if (hap + arr[i] <= s) {
                    dfs(hap + arr[i], i);
                }
            } else {
                dfs(hap + arr[i], i);
            }
        }
    }
}
