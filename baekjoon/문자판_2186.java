package baekjoon;

import java.io.*;
import java.util.*;

public class 문자판_2186 {
    static int N, M, K, mm[][][], dx[] = {0, 1, 0, -1}, dy[] = {-1, 0, 1, 0};
    static char[][] arr;
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        word = bf.readLine();
        mm = new int[N][M][word.length()];

        for(int[][] arr1 : mm) {
            for(int[] arr2 : arr1) {
                Arrays.fill(arr2, -1);
            }
        }

        int ans = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(arr[i][j] == word.charAt(0)) {
                    ans += bfs(i, j, 0);
                }
            }
        }
        
        System.out.println(ans);
    }

    private static int bfs(int x, int y, int idx) {

        if(idx == word.length()-1) {
            return 1;
        }

        if(mm[x][y][idx] != -1) {
            return mm[x][y][idx];
        }

        mm[x][y][idx] = 0;

        for(int i=0;i<4;i++) {
            for(int j=1;j<=K;j++) {
                int nx = x+dx[i]*j, ny = y+dy[i]*j;
                if(isInRange(nx, ny) && arr[nx][ny] == word.charAt(idx+1)) {
                    mm[x][y][idx] += bfs(nx, ny, idx+1);
                }
            }
        }


        return mm[x][y][idx];
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
