package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_1012 {
    static int M;
    static int N;
    static int[][] visited;
    static int[][] cabbage;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
            cabbage = new int[M][N];
            visited = new int[M][N];
            int cnt = Integer.parseInt(st.nextToken());

            for(int i=0;i<cnt;i++) {
                st = new StringTokenizer(bf.readLine());
                cabbage[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            int bug = 0;

            for(int i=0;i<M;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j]==0 && cabbage[i][j]==1) {
                        bug++; countCabbage(i, j);
                    }
                }
            }
            System.out.println(bug);
        }
    }

    static void countCabbage(int x, int y) {
        // System.out.println("x: "+x+", y: "+y);
        if(x<0 || x>M-1 || y<0 || y>N-1 || visited[x][y] != 0) {
            return;
        }
        visited[x][y] = 1;
        if(cabbage[x][y] == 1) {
            countCabbage(x+1, y); countCabbage(x-1, y); countCabbage(x, y-1); countCabbage(x, y+1);
        }
    }
}
