package baekjoon;

import java.io.*;
import java.util.*;

public class 상범빌딩_6593 {
    static class Loc {
        int x,y,z;

        Loc(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "x: "+x+", y: "+y+", z: "+z;
        }
    }
    static int L, R, C, time;
    static char arr[][][];
    static Loc myLoc, endPoint, stairs[];
    static int[] dx = {-1, 0, 1, 0, 0, 0}, dy = {0, 1, 0, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
    static Queue<Loc> queue;
    static boolean escaped, visited[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            L = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0) {
                bw.flush();
                return;
            }
            queue = new ArrayDeque<>(); time = 0; escaped = false;
            arr = new char[L][R][C]; stairs = new Loc[L-1]; visited = new boolean[L][R][C];
            for(int i=0;i<L;i++) {
                for(int j=0;j<R;j++) {
                    arr[i][j] = bf.readLine().toCharArray();
                    for(int k=0;k<C;k++) {
                        if(arr[i][j][k] == 'S') myLoc = new Loc(i, j, k);
                        if(arr[i][j][k] == 'E') endPoint = new Loc(i, j, k);
                        // if(i != 0 && arr[i-1][j][k] == '.' && )
                    }
                }
                bf.readLine();
            }

            visited[myLoc.x][myLoc.y][myLoc.z] = true;
            queue.offer(myLoc);
            while(!queue.isEmpty() && !escaped) {
                time++;
                bfs();
            }

            if(!escaped) bw.write("Trapped!\n");
            if(escaped) bw.write("Escaped in "+Integer.toString(time)+" minute(s).\n");
        }
        
        
        

    }
    static void bfs() {
        Queue<Loc> returnQueue = new ArrayDeque<>();
        while(!queue.isEmpty()) {
            Loc loc = queue.poll();
            for(int i=0;i<6;i++) {
                Loc newLoc = new Loc(loc.x+dx[i], loc.y + dy[i], loc.z + dz[i]);
                if(isInRange(newLoc) && visited[newLoc.x][newLoc.y][newLoc.z] == false) {
                    visited[newLoc.x][newLoc.y][newLoc.z] = true;
                    if(reachEndPoint(newLoc)) {
                        escaped = true; return;
                    }
                    returnQueue.offer(newLoc);
                    
                }
            }
        }
        queue = returnQueue;
    }

    static boolean reachEndPoint(Loc newLoc) {
        return newLoc.x == endPoint.x && newLoc.y == endPoint.y && newLoc.z == endPoint.z;
    }
    static boolean isInRange(Loc loc) {
        return loc.x >= 0 && loc.x < L && loc.y >= 0 && loc.y < R && loc.z >= 0 && loc.z < C && (arr[loc.x][loc.y][loc.z] == '.' || arr[loc.x][loc.y][loc.z] == 'E') ;
    }
}
