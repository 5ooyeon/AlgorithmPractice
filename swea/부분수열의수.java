package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의수 {
    static int[] arr;
    static int n;
    static int maxhap;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken()); maxhap = Integer.parseInt(st.nextToken());
            cnt = 0;

            st = new StringTokenizer(bf.readLine());
            arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<n;i++) {
                count(i, arr[i]);
            }
            sb.append("#"+tc+" "+cnt+"\n");
        }

        System.out.println(sb.toString());

    }
    static void count(int idx, int hap) {
        if(maxhap < hap) {
            return;
        }

        if(maxhap == hap) {
            cnt++;
            return;
        }

        for(int i=idx+1;i<n;i++) {
            count(i, hap+arr[i]);
        }
    }
}
