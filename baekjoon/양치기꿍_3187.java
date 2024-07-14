package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양치기꿍_3187 {
    static char[][] map;
    static boolean[][] visited;
    static int R, C, vCnt, kCnt, dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    static class Loc {
        int x, y;

        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Loc> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        map = new char[R][C]; visited = new boolean[R][C];

        for(int i=0;i<R;i++) {
            map[i] = bf.readLine().toCharArray();
        }

        int vAns = 0, kAns = 0;

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(!visited[i][j] && map[i][j] != '#') {
                    visited[i][j] = true;
                    vCnt = 0; kCnt = 0;
                    if(map[i][j] == 'v') vCnt++;
                    if(map[i][j] == 'k') kCnt++;

                    queue = new ArrayDeque<>();
                    queue.offer(new Loc(i, j));

                    while(!queue.isEmpty()) {
                        Loc loc = queue.poll();
                        for(int idx = 0; idx < 4; idx++) {
                            int x = loc.x + dx[idx], y = loc.y + dy[idx];
                            if(!isInRange(x, y)) continue;
                            if(!visited[x][y]) {
                                visited[x][y] = true;
                                if(map[x][y] == '#') continue;
                                queue.offer(new Loc(x, y));
                                if(map[x][y] == 'v') vCnt++;
                                if(map[x][y] == 'k') kCnt++;
                            }
                        }
                    }
                    
                    if(kCnt > vCnt) {
                        kAns += kCnt;
                    } else {
                        vAns += vCnt;
                    }
                }
            }
        }
        System.out.println(kAns+" "+vAns);
    }
    static boolean isInRange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

}
