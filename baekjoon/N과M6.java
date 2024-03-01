package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과M6 {
    static int n, m, arr[], visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new int[n];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        LinkedList<Integer> ansList = new LinkedList<>();

        dfs(ansList);
        System.out.println(sb.toString());
    }

    static void dfs(LinkedList<Integer> ansList) {
        if(ansList.size()== m) {
            for(int a : ansList) {
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<n;i++) {
            if(visited[i] == 0 ) {
                if(!ansList.isEmpty() && arr[i] < ansList.getLast()) {
                    continue;
                }
                visited[i] = 1;
                ansList.add(arr[i]);
                dfs(ansList);
                visited[i] = 0;
                ansList.removeLast();
            }
        }
    }
}
