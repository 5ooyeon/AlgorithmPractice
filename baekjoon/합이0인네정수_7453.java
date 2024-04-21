package baekjoon;

import java.util.*;
import java.io.*;

public class 합이0인네정수_7453 {
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[4][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<4;j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        long[] arr1 = new long[N*N];
        long[] arr2 = new long[N*N];

        int idx = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                arr1[idx] =(long) arr[0][i] + arr[1][j];
                arr2[idx] =(long) arr[2][i] + arr[3][j];
                idx++;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int ans = 0;
        int jIdx = arr2.length-1;
        a : for(int i=0;i<arr1.length;i++) {
            for(int j=jIdx;j>=0;j--) {
                long hap = arr1[i] + arr2[j];
                if(hap == 0) ans++;
                if(hap < 0) {
                    jIdx = j;
                    continue a;
                }
            }
        }

        System.out.println(ans);

    }
}