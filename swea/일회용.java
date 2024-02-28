package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 일회용 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        for(int tc = 1 ; tc <= t; tc++) {
            sb.append("#"+tc+" ");
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()), min = Integer.parseInt(st.nextToken()), max = Integer.parseInt(st.nextToken());
            LinkedList<Integer> list = new LinkedList<>();

            st = new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens()) {
                list.offer(Integer.parseInt(st.nextToken()));
            }

            if(min*3 > n || max*3 < n ) {
                sb.append("-1\n"); continue;
            }

            Collections.sort(list);
            int idx = -1, idx2 = -1;

            

        }
    }
    static void
}
