package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대힙_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(bf.readLine());
            if(num > 0) {
                pq.offer(num);
            } else {
                Integer ans = pq.poll();
                sb.append(ans == null ? 0 : ans).append("\n");
            }
        }
        System.out.print(sb);
    }
}
