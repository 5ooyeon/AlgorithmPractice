package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적록색약_10026 {

    static char[][] arr;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        arr = new char[N][];
        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        int p1 = 0;
        visited = new int[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visited[i][j]==0) {
                    p1++;
                    dfs1(i, j, arr[i][j]);
                }
            }
        }

        visited = new int[N][N];
        int p2 = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visited[i][j] == 0) {
                    p2++;
                    dfs2(i, j, arr[i][j]);
                }
            }
        }

        System.out.println(p1+" "+p2);

    }

    static void dfs1(int x, int y, char colour) {
        visited[x][y] = 1;
        for(int i=0;i<4;i++) {
            try {
                if(visited[x+dx[i]][y+dy[i]] == 0 && arr[x+dx[i]][y+dy[i]] == colour) {
                    dfs1(x+dx[i], y+dy[i], colour);
                }
            } catch (Exception e) {
            }
        }
    }
    static void dfs2(int x, int y, char colour) {
        visited[x][y] = 1;
        for(int i=0;i<4;i++) {
            try {
                if(visited[x+dx[i]][y+dy[i]] == 0) {
                    switch (colour) {
                        case 'R': case 'G':
                            if(arr[x+dx[i]][y+dy[i]] == 'G' || arr[x+dx[i]][y+dy[i]] == 'R') {
                                dfs2(x+dx[i], y+dy[i], colour);
                            }
                            break;
                    
                        default:
                            if(arr[x+dx[i]][y+dy[i]] == 'B') {
                                dfs2(x+dx[i], y+dy[i], colour);
                            }
                            break;
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
