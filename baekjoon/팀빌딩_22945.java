package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 팀빌딩_22945 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int p1 = 0, p2 = N-1;

        while(p1 < p2) {
            max = Math.max(max, Math.min(arr[p1], arr[p2])* (p2-p1-1));
            if(arr[p1] < arr[p2]) {
                int temp = arr[p1];
                while(arr[p1] <= temp) {
                    p1++;
                }
            } else {
                int temp = arr[p2];
                while(arr[p2] <= temp) {
                    p2--;
                }
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }
}
