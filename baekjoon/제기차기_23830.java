package baekjoon;

import java.io.*;
import java.util.*;

public class 제기차기_23830 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 N 값을 읽음
        int N = Integer.parseInt(bf.readLine());
        
        // 두 번째 줄에서 점수 배열을 읽음
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        
        // 세 번째 줄에서 p, q, r, S 값을 읽음
        st = new StringTokenizer(bf.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        // K의 최솟값을 이진 탐색으로 찾기
        long left = 1;
        long right = Integer.MAX_VALUE;
        long answer = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long hap = calculateHap(score, N, mid, p, q, r);

            if (hap >= S) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static long calculateHap(int[] score, int N, long K, int p, int q, int r) {
        long hap = 0;
        for (int i = 0; i < N; i++) {
            if (score[i] > K + r) {
                hap += score[i] - p;
            } else if (score[i] < K) {
                hap += score[i] + q;
            } else {
                hap += score[i];
            }
        }
        return hap;
    }
}
