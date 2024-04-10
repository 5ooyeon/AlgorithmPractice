package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_9465 {
    static int arr[][], N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for(int tc = 1; tc<=t ; tc++) {
            N = Integer.parseInt(bf.readLine());
            arr = new int[2][N];
            for(int i=0;i<2;i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            

        }
    }
}
