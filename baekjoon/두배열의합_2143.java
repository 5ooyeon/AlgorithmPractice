package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두배열의합_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(bf.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); Arrays.sort(B);

        // 1 1 2 3
        // 1 2 3
    }
}

