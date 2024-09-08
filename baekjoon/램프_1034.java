package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 램프_1034 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] offCount = new int[N];
        String[] arr = new String[N];

        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine();
            int zero = 0;
            for(int j=0;j<M;j++) {
                if(arr[i].charAt(j)=='0') {
                   zero++;
                }
            }
            offCount[i] = zero;
        }

        int cnt = Integer.parseInt(bf.readLine());
        int ans = 0;
        for(int i=0;i<N;i++) {
            if(offCount[i] <= cnt && (cnt - offCount[i])%2 == 0) {
                int lightCnt = 1;

                for(int j=0;j<N;j++) {
                    if(i!=j && arr[i].equals(arr[j])) {
                        lightCnt++;
                    }
                }
                ans = Math.max(ans, lightCnt);
            }
        }

        System.out.println(ans);
    }
}
