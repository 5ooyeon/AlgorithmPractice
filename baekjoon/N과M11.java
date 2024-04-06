package baekjoon;

import java.io.*;
import java.util.*;

public class N과M11 {
    static int n, m, arr[];
    static         StringBuilder sb = new StringBuilder();
    // static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        arr = new int[set.size()];
        
        Iterator itr = set.iterator();

        for(int i=0;i<arr.length;i++) {
            arr[i] = (int) itr.next();
        }

        Arrays.sort(arr);
        int[] ans = new int[m];
        dfs(ans, 0);
        System.out.print(sb);
    }
        
    static void dfs(int[] ans, int idx) {
        if(idx == m) {
            for(int i=0;i<idx;i++) {
                sb.append(ans[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<arr.length;i++) {
            ans[idx] = arr[i];
            dfs(ans, idx+1);
        }
    }
}
