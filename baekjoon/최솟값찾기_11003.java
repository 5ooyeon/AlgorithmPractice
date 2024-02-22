package baekjoon;

import java.io.*;
import java.util.*;

public class 최솟값찾기_11003 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> q = new ArrayDeque<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int num = Integer.parseInt(st.nextToken()), size = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            q.offer(n);
            pq.offer(n);
            if(q.size() > size) {
                int temp = q.remove();
                map.put(temp, map.get(temp)-1);
            }

            while(map.get(pq.peek())==0) {
                pq.remove();
            }

            sb.append(pq.peek()+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
