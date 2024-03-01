package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스_2606 {
    static int com, t, ans, visited[];
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(bf.readLine());
        int t = Integer.parseInt(bf.readLine());
        ans = 0;
        visited = new int[com];
        arr = new ArrayList[com];
        for(int i=0;i<com;i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0;i<t;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            arr[a].add(b);
            arr[b].add(a);
        }
        visited[0] = 1;
        dfs(0);
        for(int i=0;i<com;i++) {
            ans+= visited[i];
        }
        System.out.println(ans-1);
    }

    private static void dfs(int x) {
        
        for(int i: arr[x]) {
            if(visited[i]==0) {
                visited[i] = 1;
                dfs(i);
            }
        }
    }
}
