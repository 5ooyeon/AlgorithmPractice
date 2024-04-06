package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 공주님을구해라_17836
 */
public class 공주님을구해라_17836 {

    static class Coor{
        int x, y;
        
        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, gramTime, gramX, gramY, time, T, arr[][], visited[][];
    static Queue<Coor> queue;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); T = Integer.parseInt(st.nextToken());

        arr = new int[N][M]; visited = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 2) {
                    gramX = i; gramY = j;
                }

            }
        }

        gramTime = -1;
        queue = new ArrayDeque<>();
        time = 0;
        queue.offer(new Coor(0, 0));
        bfs();

        if(gramTime != -1) {
            time = Math.min(time, gramTime);
        }

        System.out.println(time > T ? "Fail" : time);
    }
    static void bfs() {

        Queue<Coor> returningQueue = new ArrayDeque<>();

        if(time > T) {
            return;
        }

        while(!queue.isEmpty()) {
            Coor coor = queue.poll();



            int x = coor.x, y = coor.y;
            if(x == N-1 && y == M-1) {
                return;
            }
            if(x == gramX && y == gramY) {
                gramTime = time + N+M- gramX-gramY-2;
                // System.out.println("time is "+time+", gramTime is "+gramTime);
            }

            for(int i=0;i<4;i++) {
                int X = x+dx[i], Y = y+dy[i];
                try {
                    if(visited[X][Y] == 0) {
                        visited[X][Y] = 1;

                        if(arr[X][Y] != 1) {
                            returningQueue.offer(new Coor(X, Y));
                        }
                        

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // TODO: handle exception
                }
            }

        }
        queue = returningQueue;
        time++;
        bfs();
    }
}
