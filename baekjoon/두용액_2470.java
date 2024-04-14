package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()), arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int p1 = 0, p2 = N-1, min = Integer.MAX_VALUE, ans[] = new int[2];
        while(p1 < p2) {
            min = Math.min(min, Math.abs(arr[p1] + arr[p2]));
            if(min == Math.abs(arr[p1] + arr[p2])) {
                ans[0] = arr[p1];
                ans[1] = arr[p2];
            }
            if(arr[p1] + arr[p2] > 0) {
                p2--;
            } else {
                p1++;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
