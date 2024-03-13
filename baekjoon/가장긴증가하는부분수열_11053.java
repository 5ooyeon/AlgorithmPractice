package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import java.util.Scanner;

public class 가장긴증가하는부분수열_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for (int i=0;i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        for (int i=0;i<n; i++) {
            dp[i] = 1;
            for (int j=0;j<i;j++) {
                if (arr[j]<arr[i] && dp[i]<dp[j]+1) {
                    dp[i] =dp[j]+ 1;
                }
            }
        }

        int max = 0;
        for (int i=0;i<n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

