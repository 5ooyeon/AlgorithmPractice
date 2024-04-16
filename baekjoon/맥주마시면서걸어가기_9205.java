package baekjoon;

import java.io.*;
import java.util.*;

public class 맥주마시면서걸어가기_9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        testcase : for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int goRange = 1000;
            int startX = Integer.parseInt(st.nextToken()), startY = Integer.parseInt(st.nextToken());
            int[][] convs = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                convs[i][0] = Integer.parseInt(st.nextToken());
                convs[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(bf.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            boolean[] vis = new boolean[n];
            Queue<int[]> que = new ArrayDeque<>();

            if(Math.abs(goalY-startY)+Math.abs(goalX-startX)<=goRange) {
                sb.append("happy\n"); continue testcase;
            }

            int nowX = startX;
            int nowY = startY;
            while (true) {
                if (Math.abs(goalY - nowY) + Math.abs(goalX - nowX) <= goRange) {
                    sb.append("happy\n"); continue testcase;
                }

                for (int i = 0; i < n; i++) {
                    if (!vis[i] && Math.abs(convs[i][1] - nowY) + Math.abs(convs[i][0] - nowX) <= goRange) {
                        que.add(new int[] { convs[i][0], convs[i][1] });
                        vis[i] = true;
                    }
                }

                if (que.isEmpty()) {
                    sb.append("sad\n"); continue testcase;
                }

                int[] arr = que.poll();
                nowX = arr[0];
                nowY = arr[1];
            }
        }
        System.out.print(sb);
    }

}
