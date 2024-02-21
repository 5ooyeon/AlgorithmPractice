package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 상근이의여행_9372 {
    
    static ArrayList<Integer>[] arr;
    static int[] visited;
    static int cnt = 0;
    static int edge = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        for(int tc =0; tc<T;tc++) {
            st = new StringTokenizer(bf.readLine());
            edge = Integer.parseInt(st.nextToken()); int node = Integer.parseInt(st.nextToken());

            arr = new ArrayList[edge];
            visited = new int[edge];
            for(int i=0;i<edge;i++) {
                arr[i] = new ArrayList<>();
            }
            for(int c=0;c<node;c++) {
                st = new StringTokenizer(bf.readLine());
                int a =Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
                arr[a].add(b); arr[b].add(a);
            }
    
            while(cnt != edge) {
                for(ArrayList<Integer> a : arr) {
                    if(a.size()!=0) {

                    }
                }
            }

        }
    }

    static void visitCntry(int country) {
        if(cnt == edge) {
            return;
        }
        for(int a : arr[country]) {
            if(visited[a] != 0 ) {
                visited[a] = 0; cnt++;
                visitCntry(a);
            }
        }
    }
}
