package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 합이0_3151
 */
public class 합이0_3151 {
    static int N, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long ans = 0;

        for(int a = 0; a<N-2;a++) {
            for(int b = a+1; b < N-1;b++) {
                int sum = arr[a]+arr[b];
                ans += (long) (getLastIndex(b+1, -sum) - getFirstIndex(b+1, -sum));
            }
        }
        System.out.println(ans);
    }

    private static int getFirstIndex(int start, int val) {
        int end = N-1;
        while(start < end) {
            int mid = (start + end) /2;
            if(arr[mid] < val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int getLastIndex(int start, int val) {
        int end = N-1;
        while(start < end) {
            int mid = (start + end) /2;
            if(arr[mid] <= val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if(start == N-1 && arr[start] == val) {
            start++;
        }
        return start;
    }
}