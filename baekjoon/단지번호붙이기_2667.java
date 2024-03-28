package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기_2667 {
    static char[][] arr;
    static int visited[][], N;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static List<Integer> list, ansList;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new char[N][N];
        visited = new int[N][N];
        ansList = new ArrayList<>();


        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
        }


        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(visited[i][j] == 0 && arr[i][j] == '1') {
                    list = new ArrayList<>();
                    dfs(i, j, 1);
                    Collections.sort(list);
                    ansList.add(list.size()-1);
                }
            }
        }

        Collections.sort(ansList);
        System.out.println(ansList.size());
        for(int i=0;i<ansList.size();i++) {
            System.out.println(ansList.get(i)+1);
        }

    }
    private static void dfs(int x, int y, int cnt) {
        visited[x][y] = 1;
        list.add(cnt);

        for(int i=0;i<4;i++) {
            try {
                if(arr[x+dx[i]][y+dy[i]] == '1' && visited[x+dx[i]][y+dy[i]] == 0) {
                    dfs(x+dx[i], y+dy[i], cnt+1);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
