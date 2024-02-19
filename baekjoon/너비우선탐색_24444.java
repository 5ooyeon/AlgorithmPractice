package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 너비우선탐색_24444 {
    static ArrayList<Integer>[] trees;
    static int[] visited;
    static int cnt = 1;

    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int edge= Integer.parseInt(st.nextToken()), node = Integer.parseInt(st.nextToken()), point = Integer.parseInt(st.nextToken())-1;

        trees = new ArrayList[edge];
        visited = new int[edge];

        for(int i=0;i<trees.length;i++) {
            trees[i] = new ArrayList<>();
        }

        for(int i=0;i<node;i++) {
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken())-1, child = Integer.parseInt(st.nextToken())-1;
            trees[parent].add(child);
            trees[child].add(parent);
        }

        queue.offer(point);
        while(!queue.isEmpty()) {
            int num = queue.poll();
            // System.out.println("num: "+num+", cnt: "+cnt);
            if(visited[num]!=0) {
                continue;
            }
            visited[num] = cnt++;
            Collections.sort(trees[num]);
            for(int i=0;i<trees[num].size();i++) {
                queue.offer(trees[num].get(i));
            }
        }

        for(int x : visited) {
            sb.append(x).append("\n");
        }
        System.out.println(sb.toString());
    }
}
