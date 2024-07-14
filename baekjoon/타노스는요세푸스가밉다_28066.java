package baekjoon;

import java.io.*;
import java.util.*;

public class 타노스는요세푸스가밉다_28066 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        if(K>=N) {
            System.out.println("1"); return;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i=1;i+K<=N;i++) {
            queue.add(K+i);
        }

        queue.add(1);
        
        while(queue.size()!=1 && queue.size() >= K-1) {
            int first = queue.poll();

            for(int i=1;i<K;i++) {
                queue.poll();
            }

            queue.offer(first);

        }

        System.out.println(queue.peek());
    }
}
