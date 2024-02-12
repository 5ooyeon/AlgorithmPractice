package baekjoon;

import java.io.*;
import java.util.*;

public class 외계인의기타연주_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        HashMap<Integer, PriorityQueue> map = new HashMap<>();

        int fingerTap = 0;

        for(int c=0;c<N;c++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pq;
            
            if(!map.containsKey(a)) {
                pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(b); fingerTap++;
                map.put(a, pq);
            } else {
                pq = map.get(a);
                while(!pq.isEmpty() && pq.peek()>b) {
                    pq.poll();
                    fingerTap++;
                }
                if(pq.isEmpty() || pq.peek()!=b) {
                    pq.add(b); fingerTap++;
                }
            }
        }
        System.out.println(fingerTap);
    }
}
