package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용액합성하기_14921 {
    static int n, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int value = Math.abs(arr[0]+arr[1]);
        int ans = arr[0]+arr[1];


            // for(int q=n-1;q>=0&&q>p;q--) {
            //     if(value > Math.abs(arr[p]+arr[q])) {
            //         value = Math.abs(arr[p]+arr[q]);
            //         ans = arr[p]+arr[q];
            //     }
            //     if(value > Math.abs(arr[p]+arr[q])) break;
            // }
        int a = 0, b = n-1;
        while(a < b) {
            if(value > Math.abs(arr[a]+arr[b])) {
                value = Math.abs(arr[a]+arr[b]);
                ans = arr[a]+arr[b];
            }
            if(arr[a]+arr[b] > 0) b--;
            else if(arr[a]+arr[b] < 0) a++;
            else break;
        }
        System.out.println(ans);
    }
}
