package baekjoon;

import java.io.*;
import java.util.*;

class 탈출_3055 {
    static class Loc {
        int x, y;
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char arr[][];
    static int N, M, time, dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1}, visited[][];
    static Queue<Loc> waterFalls = new ArrayDeque<>(), myLocs = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new char[N][M]; visited = new int[N][M];
        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
            for(int j=0;j<M;j++) {
                if(arr[i][j] == 'S') {
                    visited[i][j] = 1;
                    myLocs.offer(new Loc(i, j));
                }
                if(arr[i][j] == '*') {
                    waterFalls.offer(new Loc(i, j));
                }
            }
        }

        time = 0;
        while(!myLocs.isEmpty()) {
            time++;
            move();
            watergoes();
        }
        System.out.println("KAKTUS");
    }
    static void watergoes() {
        Queue<Loc> returnQueue = new ArrayDeque<>();
        while(!waterFalls.isEmpty()) {
            Loc waterFall = waterFalls.poll();
            arr[waterFall.x][waterFall.y] = '*';
            for(int i=0;i<4;i++) {
                int x = waterFall.x+dx[i], y = waterFall.y+dy[i];
                if(!isInRange(x, y)) continue;
                if(arr[x][y] == '.') {
                    arr[x][y] = '*';
                    returnQueue.offer(new Loc(x, y));
                }
            }
        }
        waterFalls = returnQueue;
    }
    static void move() {
        Queue<Loc> returnQueue = new ArrayDeque<>();
        while(!myLocs.isEmpty()) {
            Loc myLoc = myLocs.poll();
            if(arr[myLoc.x][myLoc.y] == '*') continue;
            for(int i=0;i<4;i++) {
                int x = myLoc.x+dx[i], y = myLoc.y+dy[i];
                if(!isInRange(x, y) || visited[x][y] != 0) continue;
                visited[x][y] = 1;
                if(arr[x][y] == 'D') {
                    System.out.println(time); System.exit(0);
                } else if(arr[x][y] == '.') {
                    returnQueue.offer(new Loc(x, y));
                }
            }
        }
        myLocs = returnQueue;
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
}