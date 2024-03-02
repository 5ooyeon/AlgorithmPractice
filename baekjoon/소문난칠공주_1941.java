package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소문난칠공주_1941 {

    static class location {
        int x;
        int y;

        location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] arr = new char[5][5];
    static int[][] visited = new int[5][5];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                if(arr[i][j] == 'S') {
                    dfs(i, j, 0, 1);
                } else {
                    dfs(j, j, 0, 0);
                }
            }
        }
    }
    static void dfs(int x, int y, int dep, int sCnt) {
        if(dep == 7) {
            if(sCnt>=4) {

            }
            ans++; return;
        }
        //우측 탐색
        if(y+1 < arr[x].length) {
            if(7-dep == 4 - sCnt) { //적어도 sCnt >=4 
                if(arr[x][y+1]== 'S') {
                    dfs(x, y+1, dep+1, sCnt+1);
                }
            } else {
                if(arr[x][y+1]=='S') {
                    dfs(x, y+1, dep+1, sCnt+1);
                } else {
                    dfs(x, y+1, dep+1, sCnt);
                }
            }
        }

        //밑 탐색
        if(x+1 < arr.length) {
            if(7-dep == 4 - sCnt) { //적어도 sCnt >=4 
                if(arr[x+1][y]== 'S') {
                    dfs(x+1, y, dep+1, sCnt+1);
                }
            } else {
                if(arr[x+1][y]=='S') {
                    dfs(x+1, y, dep+1, sCnt+1);
                } else {
                    dfs(x+1, y, dep+1, sCnt);
                }
            }
        }

    }
}
