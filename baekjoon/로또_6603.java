package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 로또_6603 {
    static int n, arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        while(n!=0) {
            arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            LinkedList<Integer> ansList = new LinkedList<>();
            dfs(ansList, 0);
            sb.append("\n");
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
        }
        System.out.print(sb.toString());
    }
    static void dfs(LinkedList<Integer> ansList, int lastIdx) {
        if(ansList.size() == 6) {
            for(int a : ansList) {
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=lastIdx;i<n;i++) {
            ansList.add(arr[i]);
            dfs(ansList, i+1);
            ansList.removeLast();
        }
    }
}
