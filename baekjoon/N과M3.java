package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과M3 {
    static int n, dep;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken()); dep = Integer.parseInt(st.nextToken());
        LinkedList<Integer> arr = new LinkedList<>();

        dfs(arr);
        
        System.out.println(sb.toString());
    }
    private static void dfs(LinkedList<Integer> arr) {
        if(arr.size() == dep) {
            for(int a : arr) {
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++) {
            arr.add(i);
            dfs(arr);
            arr.removeLast();
        }
    }

}
