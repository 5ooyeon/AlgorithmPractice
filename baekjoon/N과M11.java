package baekjoon;

import java.io.*;
import java.util.*;

public class N과M11 {
    static int n,m, arr[];
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> ansList = new LinkedList<>();
        dfs(ansList);
        ArrayList<String> ans = new ArrayList<>(set);
        Collections.sort(ans, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                StringTokenizer st1 = new StringTokenizer(o1);
                StringTokenizer st2 = new StringTokenizer(o2);
                while(st1.hasMoreTokens()) {
                    int t1 = Integer.parseInt(st1.nextToken()), t2 = Integer.parseInt(st2.nextToken());
                    if(t1 != t2) {
                        return t1-t2;
                    }
                }
                return 0;
            }
            
        });
        for(String a : ans) {
            sb.append(a+"\n");
        }
        System.out.print(sb.toString());
    }
    static void dfs(LinkedList<Integer> ansList) {
        if(ansList.size() == m) {
            StringBuilder sb = new StringBuilder();
            for(int a : ansList) {
                sb.append(a+" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i=0;i<n;i++) {
            ansList.add(arr[i]);
            dfs(ansList);
            ansList.removeLast();
        }
    }
}
