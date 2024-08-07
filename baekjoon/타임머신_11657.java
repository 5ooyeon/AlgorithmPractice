package baekjoon;

import java.io.*;
import java.util.*;

public class 타임머신_11657 {
    static class Info {
        int start, end, cost;

        Info(int s, int e, int v) {
            this.start = s;
            this.end = e;
            this.cost = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        List<Info> edges = new ArrayList<>();
        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());

            edges.add( new Info(start, end, cost) );
        }

        // 500 * 6000 * 10000이 int의 범위를 넘어감
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        // n - 1 번의 반복작업과 마지막 확인작업을 한 번에 돌림
        for(int i = 1 ; i <= n ; i ++) {
            for(Info edge : edges) {
                // 한번도 들른적 없으면 패스
                // Long 최대값으로 초기화했기 때문에 이 작업 반드시 필요
                if(dist[edge.start] == Long.MAX_VALUE) continue;

                // 버스 도착점까지의 최소거리가 시작점 + 비용보다 크면 갱신
                if(dist[edge.end] > dist[edge.start] + edge.cost) {
                    dist[edge.end] = dist[edge.start] + edge.cost;

                    // n번째 작업에서 값이 변경되면 무한히 되돌아 갈 수 있다는 뜻
                    if(i == n) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        for(int i = 2 ; i <= n ; i ++) {
            if(dist[i] == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}