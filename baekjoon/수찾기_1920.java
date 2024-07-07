package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        getM : for(int t = 0;t<M;t++) {
            int start = 0, end = N-1, mid = end/2;
            int target = Integer.parseInt(st.nextToken());

            while(start < end) {
                if(arr[mid] == target || arr[start] == target || arr[end] == target) {
                    sb.append("1\n"); continue getM;
                } else if(arr[mid] > target) {
                    end = mid - 1;
                    mid = (start+end)/2;
                } else {
                    start = mid + 1;
                    mid = (start + end) /2;
                }
            }
            sb.append("0\n");
        }

        System.out.println(sb);
    }
}
