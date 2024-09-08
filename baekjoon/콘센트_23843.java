package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 콘센트_23843 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            pq.add(0);
        }
        for (int i = N - 1; i >= 0; i--) {
            int tmp = pq.poll() + arr[i];
            pq.add(tmp);
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            ans = Math.max(pq.poll(), ans);
        }
        System.out.println(ans);
    }
}