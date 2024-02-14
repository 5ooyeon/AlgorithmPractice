package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 절댓값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Long> minPQ = new PriorityQueue<>();
        PriorityQueue<Long> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N;i++) {
            String input= bf.readLine();
            if(!input.equals("0")) {
                Long temp = Long.parseLong(input);
                if(temp > 0) {
                    minPQ.add(temp);
                } else {
                    maxPQ.add(temp);
                }
            } else {
                if(minPQ.isEmpty() && maxPQ.isEmpty()) {
                    sb.append("0");
                } else if(minPQ.isEmpty()) {
                    sb.append(maxPQ.poll());
                } else if(maxPQ.isEmpty()) {
                    sb.append(minPQ.poll());
                } else {
                    if(minPQ.peek() < -maxPQ.peek()) {
                        sb.append(minPQ.poll());
                    } else {
                        sb.append(maxPQ.poll());
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
