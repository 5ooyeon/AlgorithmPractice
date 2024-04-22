package baekjoon;

import java.io.*;
import java.util.*;

public class 텀프로젝트_9466 {
    static int N, arr[], returnAns;
    static boolean visited[], getTeam[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc<= t; tc++) {
            N = Integer.parseInt(bf.readLine());
            arr = new int[N]; getTeam = new boolean[N]; visited = new boolean[N];

            StringTokenizer st = new StringTokenizer(bf.readLine());

            returnAns = 0;

            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken())-1;

                if(arr[i] == i) {
                    visited[i] = true; getTeam[i] = true; returnAns++;
                }

            }

            for(int i=0;i<N;i++) {
                if(!getTeam[i]) {
                    dfs(i);
                }
            }

            bw.write(Integer.toString(N-returnAns)+"\n");
        }
        bw.flush();
    }
    static void dfs(int i) {
        if(visited[i] && getTeam[i] == false) {
            getTeam[i] = true;
            returnAns++;
        } else {
            visited[i] = true;
        }

        if(!getTeam[arr[i]]) {
            dfs(arr[i]);
        }
        
        visited[i] = false;
    }
}