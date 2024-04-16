package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 인구이동_16234 {
    static class Location {
        int x, y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, L, R, arr[][], check[][], hap, cnt;
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
                        int[] temp = dfs(i, j)
                    }
                }
            }
        }
    }
    static int[][] changePop(int idx, int amount) {
        int[][] returnArr = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(check[i][j] == idx) {
                    returnArr[i][j] = amount;
                } else {
                    returnA
                }
            }
        }
    }
    static void dfs(int x, int y, int idx) {
        for(int i=0;i<4;i++) {
            try {
                if(isInRange(x+dx[i], y+dy[i]) && check[x+dx[i]][y+dy[i]] == 0) {
                    check[x+dx[i]][y+dy[i]] = idx; cnt++;
                    hap += arr[x+dx[i]][y+dy[i]];
                    dfs(x+dx[i], y+dy[i], idx);
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
