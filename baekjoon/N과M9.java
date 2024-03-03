package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과M9 {
    static int n, m, arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        LinkedList<Integer> ansList = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        dfs(ansList, set);
        System.out.print(sb.toString());
    }
    private static void dfs(LinkedList<Integer> ansList, HashSet<Integer> set) {
        if(ansList.size() == m) {
            for(int a : ansList) {
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++) {
            int temp = arr[i];
            if(!set.contains((Integer) temp)) {
                set.add((Integer) temp);
                ansList.add(arr[i]);
                dfs(ansList, set);
                set.remove(temp);
                ansList.removeLast();
            }
        }
    }
}
