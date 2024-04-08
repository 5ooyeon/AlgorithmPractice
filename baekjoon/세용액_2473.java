package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액_2473 {
    static long N, arr[], max, ans[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(bf.readLine());
        arr = new long[(int) N]; ans = new long[3];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        max = Long.MAX_VALUE;

        int pointer1, pointer2, pointer3;
        whole : for(pointer1 = 0; pointer1 < N; pointer1++) {
            pointer2 = pointer1+1; pointer3 = (int) N-1;

            while(pointer2 < pointer3) {
                long temp = arr[pointer1] +arr[pointer2] + arr[pointer3];

                if(Math.abs(temp) < max) {
                    max = Math.abs(temp);
                    ans[0] = arr[pointer1];
                    ans[1] = arr[pointer2];
                    ans[2] = arr[pointer3];
                }

                if(temp < 0) {
                    pointer2++;
                } else if(temp ==0) {
                    break whole;
                } else {
                    pointer3--;
                }
            }
        }
        for(long a : ans) {
            System.out.print(a+" ");
        }
        
    }
}
