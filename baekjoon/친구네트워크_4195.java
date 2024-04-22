package baekjoon;

import java.io.*;
import java.util.*;

public class 친구네트워크_4195 {
    static HashMap<String, Integer> map = new HashMap<>();
    static int arr[], parent[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(bf.readLine());
            arr = new int[200000];
            parent = new int[200000][2];

            for(int i=0;i<200000;i++) {
                parent[i][0] = i;
                parent[i][1] = 1;
            }

            int idx = 0;
            for (int tcn = 1; tcn <= n; tcn++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String friendA = st.nextToken(), friendB = st.nextToken();
                int a, b;

                if (map.get(friendA) == null) {
                    // arr[idx] = idx;
                    map.put(friendA, idx);
                    idx++;
                }
                a = map.get(friendA);

                if (map.get(friendB) == null) {
                    // arr[idx] = idx;
                    map.put(friendB, idx);
                    idx++;
                }
                b = map.get(friendB);

                int findA = find(a), findB = find(b);
                if (findA != findB) {
                    parent[findA][0] = findB;
                    parent[findA][1] += parent[findB][1];
                    parent[findB][1] = parent[findA][1];
                }
                sb.append(parent[findA][1]+"\n");
            }
        }
        System.out.print(sb);
    }

    static int find(int friend) {
        if(parent[friend][0] == friend) return friend;
        return parent[friend][0] = find(parent[friend][0]);
    }
}
