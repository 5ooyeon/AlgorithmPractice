package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수고르기_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        int start = 0, end = 0, ans = Integer.MAX_VALUE;
        while (start <= end && end < N) {
            if (arr[end] - arr[start] >= M) {
                ans = Math.min(ans, arr[end] - arr[start]);
                start++;
            } else
                end++;
        }
        System.out.println(ans);
    }
}
