package baekjoon;

import java.io.*;
import java.util.*;

public class 스타트링크_5014 {

    static class Data {
        int height, cnt;

        Data(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        } 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int F = Integer.parseInt(st.nextToken()),
        S = Integer.parseInt(st.nextToken()),
        G = Integer.parseInt(st.nextToken()),
        U = Integer.parseInt(st.nextToken()),
        D = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[F];

        PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {

            @Override
            public int compare(Data o1, Data o2) {
                if(Math.abs(G-o1.height) == Math.abs(G-o2.height)) {
                    return Integer.compare(o1.cnt, o2.cnt);
                }
                return Integer.compare(Math.abs(G-o1.height), Math.abs(G-o2.height));
            }
            
        });

        pq.offer(new Data(S, 0));

        if( (D==0 && S > G) || (U==0 && S < G)) {
            System.out.println("use the stairs");
              return;
        }

        while(!pq.isEmpty()) {
            Data data = pq.poll();
            if(data.height == G) {
                System.out.println(data.cnt); 
                return;
            }

            if(data.height + U <= F && !visited[data.height + U - 1]) {
                visited[data.height + U - 1] = true;
                pq.offer(new Data(data.height + U, data.cnt+1));
            }
            if(data.height - D > 0 && !visited[data.height - D - 1]) {
                visited[data.height - D - 1] = true;
                pq.offer(new Data(data.height - D, data.cnt + 1));
            }

        }
        System.out.println("use the stairs");
    }
}
