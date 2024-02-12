package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023 {
    static ArrayList<Integer>[] abcde;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int edge = Integer.parseInt(st.nextToken()), node = Integer.parseInt(st.nextToken());
        abcde = new ArrayList[edge];
        visited = new int[edge];
        
        for (int i = 0; i < edge; i++) {
            abcde[i] = new ArrayList<>();
        }

        for(int i=0;i<node;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            abcde[a].add(b); abcde[b].add(a);
        }
        for(int i=0;i<edge;i++) {
            getFriends(i, 0);
            visited = new int[edge];
        }
        System.out.println(0);
    }
    private static void getFriends(int personIdx, int cnt) {

        if(visited[personIdx]==1) {
            return;
        }
        if(cnt == 4) {
            // System.out.println(personIdx);
            System.out.println(1); System.exit(0);
        }
        visited[personIdx] = 1;
        for(int i : abcde[personIdx]) {
            // System.out.println("personIdx: "+personIdx+", i: "+i+", cnt: "+cnt);
            getFriends(i, cnt+1);
        }
        visited[personIdx] = 0;
    }
}
