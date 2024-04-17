package baekjoon;

import java.io.*;
import java.util.*;

public class 인구이동_16234 {
    static class Location {
        int x, y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, L, R, arr[][], check[][], hap, cnt;
    static Queue<Location> queue = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        
        while(true) {

            boolean isChanged = false;
            check = new int[N][N];

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(check[i][j] == 0) {
                        hap = 0; cnt = 0; queue.clear();
                        dfs(i, j);

                        if(cnt != 1) {
                            isChanged = true;
                            while(!queue.isEmpty()) {
                                Location loc = queue.poll();
                                arr[loc.x][loc.y] = hap/cnt;
                            }
                        }

                    }
                }
            }
            
            if(!isChanged) {
                System.out.println(day); return;
            }
            
            day++;
        }
    }

    private static void dfs(int x, int y) {

        check[x][y] = 1;
        queue.offer(new Location(x, y));
        cnt++;
        hap += arr[x][y];

        for(int i=0;i<4;i++) {
            try {
                int value = Math.abs(arr[x+dx[i]][y+dy[i]] - arr[x][y]);
                if(check[x+dx[i]][y+dy[i]] == 0 && value >= L && value <= R) {
                    dfs(x+dx[i], y+dy[i]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
        }
    }

}
