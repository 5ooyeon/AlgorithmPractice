package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단지번호붙이기_2667 {
    static char[][] arr;
    static int visited[][], N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new char[N][N];
        visited = new int[N][N];

        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visited[i][j]== 0 && arr[i][j] == '1') {
                    dfs(i, j);
                }
            }
        }
    }
    private static void dfs(int x, int y) {
        visited[x][y] = 1;
        for(int i=x;i<N;i++) {

        }
    }
}
