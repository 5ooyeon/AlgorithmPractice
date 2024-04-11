package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용액_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int p1 = 0; int p2 = N-1; int hap = 0; int min = Integer.MAX_VALUE; int[] ans = new int[2];
        while(p1 < p2) {
            hap = arr[p1]+arr[p2];
            min = Math.min(Math.abs(hap), min);
            if(min==Math.abs(hap)) {
                ans[0] = arr[p1]; ans[1] = arr[p2];
            }

            if(hap> 0) {
                p2--;
            } else if(hap < 0) {
                p1++;
            } else {
                break;
            }
        }
        System.out.println(ans[0]+" "+ans[1]);
    }
}
