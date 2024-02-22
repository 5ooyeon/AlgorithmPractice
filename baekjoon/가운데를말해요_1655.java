package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> minpq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxpq = new PriorityQueue<>();

        minpq.offer(Integer.parseInt(bf.readLine()));
        sb.append(minpq.peek()+"\n");
        for(int i=1;i<N;i++) {
            int temp = Integer.parseInt(bf.readLine());
            if(minpq.peek() >= temp) {
                minpq.offer(temp);
            } else {
                maxpq.offer(temp);
            }
            
            while(minpq.size()-maxpq.size()!=1 && minpq.size()-maxpq.size() != 0) {
                if(maxpq.size() >= minpq.size()) {
                    minpq.offer(maxpq.poll());
                } else if(maxpq.size() < minpq.size()) {
                    maxpq.offer(minpq.poll());
                }
            }

            sb.append(minpq.peek()+"\n");
            
        }
        System.out.println(sb.toString());
    }
}
