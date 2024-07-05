package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 볼링장아르바이트_27979 {
    static int N, arr[], arr2[], lastIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        arr2 = new int[N];

        lastIdx = N-1;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];
//            lastIdx = Math.max(lastIdx, arr[i]);
        }

        Arrays.sort(arr2);


    }
}
