package A형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 창용마을무리의개수 {

    static ArrayList<Integer>[] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int edge = Integer.parseInt(st.nextToken()), node = Integer.parseInt(st.nextToken());

            arr = new ArrayList[edge];
            visited = new int[edge];

            for(int i=0;i<edge;i++) {
                arr[i] = new ArrayList<>();
            }

            for(int c =0; c < node; c++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;

                arr[a].add(b);
                arr[b].add(a);
            }

            int ans =0;

            for(int i=0;i<edge;i++) {
                if(visited[i]==0) {
                    ans++; muri(i);
                }
            }
            sb.append("#"+tc+" "+ans+"\n");
            
        }
        System.out.println(sb.toString());
    }

    static void muri(int num) {

        visited[num] = 1;

        for(int n : arr[num]) {
            if(visited[n]==0) {
                muri(n);
            }
        }
    }
}
