package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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

        for(int i=1;i<N;i++) {
            int temp = Integer.parseInt(bf.readLine());
            if(minpq.peek() >= temp) {
                minpq.offer(temp);
            } else {
                maxpq.offer(temp);
            }

            
            while(minpq.size()-1 > maxpq.size()) {
                maxpq.offer(minpq.poll());
            }

            System.out.println(minpq.peek());
            
        }

    }
}
