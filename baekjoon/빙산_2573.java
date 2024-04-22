package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙산_2573 {
    static int N, M, arr[][], visited[][], cnt, checkCnt;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cnt = 0;
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) cnt++;
            }
        }

        int time = 1;
        while(true) {
            visited = new int[N][M];
            int c = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(arr[i][j] != 0 && visited[i][j] == 0) {
                        c++;
                        checkCnt = 0;
                        visited[i][j] = 1;
                        dfs(i, j);
                    }
                }
            }
            if(c == 0) {
                System.out.println(0); return;
            } else if(c >= 2) {
                System.out.println(time-1); return;
            }
            time++;
        }

    }


    static void dfs(int x, int y) {
        int zeroCnt = 0;
        for(int i=0;i<4;i++) {
            try {
                if(arr[x+dx[i]][y+dy[i]] == 0) {
                    zeroCnt++;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        
        for(int i=0;i<4;i++) {
            try {
                if(arr[x+dx[i]][y+dy[i]] != 0 && visited[x+dx[i]][y+dy[i]] == 0) {
                    visited[x+dx[i]][y+dy[i]] = 1;
                    dfs(x+dx[i], y+dy[i]);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        arr[x][y] -= zeroCnt;
        arr[x][y]= arr[x][y] < 0 ? 0 : arr[x][y];
        checkCnt++;
    }
}
