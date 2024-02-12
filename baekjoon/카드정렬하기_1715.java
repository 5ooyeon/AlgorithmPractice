package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ans = 0;
        for(int tc =0;tc<N;tc++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }
        while(pq.size()!=1) {
            int temp = pq.poll() +pq.poll();
            ans += temp;
            pq.add(temp);
        }
        System.out.println(ans);

    }
}
