package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과M7 {
    static int n, m, arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(bf.readLine());

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        LinkedList<Integer> ansList = new LinkedList<>();
        Arrays.sort(arr);
        dfs(ansList);
        System.out.println(sb.toString());
    }
    static void dfs(LinkedList<Integer> ansList) {
        if(ansList.size() == m) {
            for(int a : ansList) {
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++) {
            ansList.add(arr[i]);
            dfs(ansList);
            ansList.removeLast();
        }
    }
}
