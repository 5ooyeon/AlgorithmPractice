package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무높이2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= t; tc++) {
            int N = Integer.parseInt(bf.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int max = arr[N-1];
            int day = 0;
            while(arr[0]!=max) {
                day++;
                if(day%2 == 1) {
                    for(int i=N-1;i>=0;i--) {
                        if(max - arr[i] >=3 || (max-arr[i]) % 2 == 1) {
                            arr[i]++; break;
                        }
                    }
                } else {
                    for(int i=N-1;i>=0;i--) {
                        if(max-arr[i] >= 2) {
                            arr[i]+=2; break;
                        }
                    }
                }
                Arrays.sort(arr);
            }
            sb.append("#"+tc+" "+day+"\n");
        }
        System.out.println(sb.toString());
    }
}
