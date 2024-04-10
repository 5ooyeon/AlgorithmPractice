package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역_2468 {
    static int N, arr[][], ans, time, max, visited[][], output;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        max = 0;
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i][j], max);
            }
        }
        ans = 1;
        time = 1;
        while(time < max) {
            visited = new int[N][N];
            output = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j] == 0&& arr[i][j] > time) {

                        output++;
                        dfs(i, j);
                    }
                }
            }
            ans = Math.max(ans, output);
            time++;
        }
        System.out.println(ans);
    }
    static void dfs(int x, int y) {
        for(int i=0;i<4;i++) {
            try {
                if(visited[x+dx[i]][y+dy[i]] == 0 && arr[x+dx[i]][y+dy[i]] > time) {
                    visited[x+dx[i]][y+dy[i]] =1;
                    dfs(x+dx[i], y+dy[i]);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
