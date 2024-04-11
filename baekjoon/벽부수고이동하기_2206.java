package baekjoon;

import java.io.*;
import java.util.*;

public class 벽부수고이동하기_2206 {

    static class Location{
        int x, y, wall;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
            this.wall = 0;
        }
        Location(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

    static int N, M, visited1[][], visited2[][];
    static char arr[][];
    static Queue<Location> queue = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static boolean findRoute = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new char[N][];

        visited1 = new int[N][M]; visited2 = new int[N][M];

        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
        }


        queue.offer(new Location(0, 0));
        int time = 0;
        while(!findRoute) {
            if(queue.isEmpty()) {
                System.out.println(-1);return;
            }
            time++;
            bfs();
        }
        System.out.println(time);
    }
    static void bfs() {
        Queue<Location> returnQueue = new ArrayDeque<>();
        while(!queue.isEmpty()) {
            Location loc = queue.poll();

            if(loc.x == N-1 && loc.y == M-1) {
                findRoute = true;
                return;
            }

            //벽을 부순 상태가 아닐 경우
            if(loc.wall == 0) {
                for(int i=0;i<4;i++) {

                    int x = loc.x+dx[i], y = loc.y+dy[i];

                    try {
                        if(arr[x][y] == '0' && visited1[x][y] == 0) {
                            visited1[x][y] = 1;
                            returnQueue.offer(new Location(x, y));
                        } else if (arr[x][y] == '1' && visited2[x][y] == 0) {
                            visited2[x][y] = 1;
                            returnQueue.offer(new Location(x, y, 1));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // TODO: handle exception
                    }
                    
                }
            } else {
                //이미 벽을 부순 상태라면
                for(int i=0;i<4;i++) {

                    int x = loc.x+dx[i], y = loc.y+dy[i];

                    try {
                        if(arr[x][y] == '0' && visited2[x][y] == 0 && visited1[x][y] == 0) {
                            visited2[x][y] = 1;
                            returnQueue.offer(new Location(x, y, 1));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        // TODO: handle exception
                    }
                    
                }
            }

        }
        queue = returnQueue;
    }
}
