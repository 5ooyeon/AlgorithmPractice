package baekjoon;

import java.io.*;
import java.util.*;

public class 연결요소의개수_11724 {
    static Boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        arr = new ArrayList[N];
        visited = new Boolean[N];

        for(int gi=0;gi<M;gi++) {
            input = bf.readLine().split(" ");
            int t1 = Integer.parseInt(input[0])-1, t2 = Integer.parseInt(input[1])-1;
            if(arr[t1]==null) {
                arr[t1] = new ArrayList<>();
            }
            if(arr[t2]==null) {
                arr[t2] = new ArrayList<>();
            }
            arr[t1].add(t2); arr[t2].add(t1);
        }

        for(int i=0;i<N;i++) {
            if(visited[i]==null) {
                cnt++; checkNodes(i);
            }
        }
        System.out.println(cnt);
    }

    static void checkNodes(int node) {
        if(visited[node] != null) {
            return;
        }

        visited[node] = true;

        if(arr[node]==null) {
            return;
        }
        for(int i=0;i<arr[node].size();i++) {
            checkNodes(arr[node].get(i));
        }
    }
}
