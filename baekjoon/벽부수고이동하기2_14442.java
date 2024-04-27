package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2_14442 {
    static class Loc{
        int x, y, wallCnt;
        
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
            wallCnt = 0;
        }

        Loc(int x, int y, int wallCnt) {
            this.x = x;
            this.y = y;
            this.wallCnt = wallCnt;
        }
    }
    static int visited[][][], N, M, K, dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1}, time;
    static char arr[][];
    static Queue<Loc> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[N][M][K];
        arr = new char[N][M];

        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        queue.offer(new Loc(0, 0));
        visited[0][0][0] = 1;
        time = 0;
        while(true) {
            time++;
            bfs();
        }

    }
    static void bfs() {
        Queue<Loc> returnQueue = new ArrayDeque<>();
        while(!queue.isEmpty()) {
            Loc loc = queue.poll();
            for(int i=0;i<4;i++) {
                int x = loc.x+dx[i], y = loc.y+dy[i];
                try {
                    if(arr[x][y] == 1) {
                        if(visited[x][y][wallCnt])
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
    }
}
