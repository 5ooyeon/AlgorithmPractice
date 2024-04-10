package baekjoon;

import java.io.*;
import java.util.*;

class 최소비용구하기_1916 {
    static class Bus implements Comparable<Bus>{
        int to,cost;

        Bus(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static List<Bus>[] busList;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()), M = Integer.parseInt(bf.readLine());

        busList = new ArrayList[N];
        int[] cost = new int[N];
        boolean[] visited = new boolean[N];

        for(int i=0;i<N;i++) {
            busList[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            busList[Integer.parseInt(st.nextToken())-1].add(new Bus(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken())-1, end = Integer.parseInt(st.nextToken())-1;

        cost[start] = 0;
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));

        while(!pq.isEmpty()) {
            Bus bus = pq.poll();
            if(!visited[bus.to]) {
                visited[bus.to] = true;
                for(Bus b : busList[bus.to]) {
                    if(cost[b.to] > bus.cost+b.cost) {
                        cost[b.to] = b.cost + bus.cost;
                        pq.offer(new Bus(b.to, cost[b.to]));
                    }
                }
            }
        }
        System.out.println(cost[end]);
    }
}


class Main {
    static class Bus implements Comparable<Bus>{
        int to,costValue;

        Bus(int to, int costValue) {
            this.to = to;
            this.costValue = costValue;
        }

        @Override
        public int compareTo(Bus o) {
            return Integer.compare(this.costValue, o.costValue);
        }
    }

    static List<Bus>[] busList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        busList = new ArrayList[N];
        int[] cost = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            busList[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int costValue = Integer.parseInt(st.nextToken());
            busList[from].add(new Bus(to, costValue));
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        cost[start] = 0;
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));

        while(!pq.isEmpty()) {
            Bus bus = pq.poll();
            int current = bus.to;
            if (visited[current]) continue;
            visited[current] = true;
            for(Bus b : busList[current]) {
                int next = b.to;
                int nextCost = b.costValue;
                if (!visited[next] && cost[next] > cost[current] + nextCost) {
                    cost[next] = cost[current] + nextCost;
                    pq.offer(new Bus(next, cost[next]));
                }
            }
        }
        System.out.println(cost[end]);
    }
}
