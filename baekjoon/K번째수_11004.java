package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K번째수_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        for(int t=1;t<K;t++) {
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}
