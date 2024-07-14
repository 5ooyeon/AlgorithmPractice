package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 만남의광장_25708 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N+1][M+1];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            int sum = 0;
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum += arr[i][j];
            }
            arr[i][M] = sum;
        }

        for(int j=0;j<M;j++) {
            int sum = 0;
            for(int i=0;i<N;i++) {
                sum += arr[i][j];
            }
            arr[N][j] = sum;
        }
        
        int hap = 0, ans = Integer.MIN_VALUE;

        for(int i1=0;i1<N-1;i1++) {
            for(int i2 = i1+1;i2<N;i2++) {
                for(int j1=0;j1<M-1;j1++) {
                    for(int j2=j1+1;j2<M;j2++) {
                        hap = arr[i1][M] + arr[i2][M] + arr[N][j1] + arr[N][j2] - arr[i1][j1] - arr[i2][j1] - arr[i1][j2] - arr[i2][j2];
                        hap += (j2 - j1 - 1) * (i2 - i1 - 1);
                        ans = Math.max(ans, hap);
                    }
                }
            }
        }
        System.out.println(ans);

    }

}
