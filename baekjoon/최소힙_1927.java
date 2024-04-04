package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(bf.readLine());
            switch (num) {
                case 0:
                    Integer returnNum = pq.poll();
                    sb.append(returnNum == null ? 0+"\n" : returnNum+"\n");
                    break;
            
                default:
                    pq.offer(num);
                    break;
            }
        }
        System.out.print(sb);
    }
}
