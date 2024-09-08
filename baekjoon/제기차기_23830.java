package baekjoon;

<<<<<<< HEAD
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
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 제기차기_23830 {
    public static void main(String[] args) throws IOException {
        System.out.println(Integer.MAX_VALUE);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] score = new int[N];
        for(int i=0;i<N;i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int[] n = new int[4];
        for(int i=0;i<4;i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }

        // int K = 10;
        //n[0] => p -> K+r 초과라면 p빼기
        //n[1] => q -> K 미만이라면 q더하기
        //n[2] => r -> K+r
        //n[3] => 계산한 모든 점수 합

        long K = 0;
        boolean eof = false;
        while(!eof) {
            K++;
            eof = true;

            long hap = 0;
            for(int i=0;i<N;i++) {
                hap += score[i];
                if(score[i] > K+n[2]) {
                    eof = false;
                    hap -= n[0];
                } else if(score[i] < K) {
                    hap += n[1];
                } else {
                    eof = false;
                }
            }
            if(hap >= n[3]) {
                System.out.println(K); return;
            }
        }
        System.out.println("-1");
>>>>>>> 948b90f59dc6c2e3b48dcb7ae1f331cea437aa8e
    }
}
