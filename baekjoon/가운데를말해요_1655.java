package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            pq.add(Integer.parseInt(bf.readLine()));
            PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
            while(temp.size() > pq.size()/2 +1) {
                temp.poll();
            }
            bw.write(temp.poll()+"\n");

        }
        bw.flush();
    }
}
