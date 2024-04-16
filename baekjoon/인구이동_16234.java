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

            int[][] returnArr = new int[N][N];
            boolean isChanged = false;

            check = new int[N][N]; int checkIdx = 1;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(isInRange(i, j)) {
                        check[i][j] = 1; isChanged = true;
                    }
                }
            }
            
            if(!isChanged) {
                System.out.println(day); return;
            }

            isChanged = false;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(check[i][j] == 1) {
                        hap = arr[i][j]; cnt = 1;
                        queue.clear(); queue.offer(new Location(i, j));
                        check[i][j] = 0;
                        putInQueue(i, j);
                        if(changePop(hap/cnt)) {
                            isChanged = true;
                        }
                    }
                }
            }
            if(!isChanged) {
                System.out.println(day);return;
            }
            day++;
        }
    }

    static boolean changePop(int newNum) {
        boolean isChanged = false;
        while(!queue.isEmpty()) {
            Location loc = queue.poll();
            int ori = arr[loc.x][loc.y];
            arr[loc.x][loc.y] = newNum;

            if(ori != newNum) isChanged = true;
        }
        return isChanged;
    }

    static void putInQueue(int i, int j) {
        for(int c=0;c<4;c++) {
            int x = i+dx[c], y = j+dy[c];
            try {
                if(check[x][y] == 1) {
                    queue.offer(new Location(x, y));
                    hap += arr[x][y]; cnt++;
                    check[x][y] = 0;
                    putInQueue(x, y);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    static boolean isInRange(int x, int y) {
        return arr[x][y] >= L && arr[x][y] <= R;
    }
}
