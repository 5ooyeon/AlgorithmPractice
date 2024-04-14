package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파일합치기_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int tc = 1;tc<=t ;tc++) {
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st= new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens()) {
                pq.offer((long) Integer.parseInt(st.nextToken()));
            }

            long ans = 0;

            for(int i=1;i<n;i++) {
                long a = pq.poll(), b = pq.poll();
                ans += a+b;
                pq.offer(a+b);
            }
            sb.append(ans+"\n");
            pq.clear();
        }
        System.out.print(sb);
    }
}
