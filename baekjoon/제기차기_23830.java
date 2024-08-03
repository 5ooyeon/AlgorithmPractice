package baekjoon;

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
    }
}
