package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N과M10 {
    static int n, m, arr[], visited[];
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        LinkedList<Integer> ansList = new LinkedList<>();
        dfs(ansList, 0);
        ArrayList<String> ans = new ArrayList<>(set);
        Collections.sort(ans, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                StringTokenizer st1 = new StringTokenizer(o1);
                StringTokenizer st2 = new StringTokenizer(o2);
                while(st1.hasMoreTokens()) {
                    int t1 = Integer.parseInt(st1.nextToken()), t2 = Integer.parseInt(st2.nextToken());
                    if(t1!= t2) {
                        return t1 - t2;
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
    static void dfs(LinkedList<Integer> ansList, int lastIdx) {
        if(ansList.size() == m) {
            StringBuilder sb = new StringBuilder();
            for(int a : ansList) {
                sb.append(a+" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i = lastIdx; i<n;i++) {
            ansList.add(arr[i]);
            dfs(ansList, i+1);
            ansList.removeLast();
        }

    }
}
