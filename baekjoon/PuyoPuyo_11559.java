package baekjoon;

import java.io.*;
import java.util.*;

public class PuyoPuyo_11559 {

    static class Location {
        int x, y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static HashSet<Location> set = new HashSet<>();

    static char[][] arr = new char[12][6];
    static int startLine = -1, blocks = 0, ans = 0;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}, visited[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<12;i++) {
            arr[i] = bf.readLine().toCharArray();
            for(int j=0;j<6;j++) {
                if(arr[i][j] != '.' && startLine == -1) startLine = i;
                if(arr[i][j] != '.') blocks++;
            }
        }
        if(startLine==-1) {
            System.out.println(0); return;
        }

        while (true) {
            boolean isChanged = false;
            visited = new int[12][6];
            for(int i=11; i>=startLine;i--) {
                for(int j=0;j<6;j++) {
                    if(arr[i][j] != '.') {

                        set.clear();
                        set.add(new Location(i, j));
                        visited[i][j] = 1;
                        dfs(i, j, arr[i][j]);

                        if(set.size() >= 4) {
                            for(Location loc : set) {
                                arr[loc.x][loc.y] = '.';
                            }
                            isChanged = true;
                            
                        }

                    }
                }
            }

            //밑으로 내리는 메소드
            if(isChanged){
                ans++;
                downBlocks();
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    static void downBlocks() {
        nextLine : for(int j=0;j<6;j++) {
            for(int i=11;i>=0;i--) {
                if(arr[i][j] == '.') {
                    int temp = i-1;
                    try {
                        while(arr[temp][j] == '.') {
                            temp--;
                        }
                        arr[i][j] = arr[temp][j];
                        arr[temp][j] = '.';
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue nextLine;
                    }
                }
            }
        }
    }

    static void dfs(int x, int y, char colour) {
        for(int i=0;i<4;i++) {
            try {
                if(arr[x+dx[i]][y+dy[i]] == colour && visited[x+dx[i]][y+dy[i]] == 0) {
                    set.add(new Location(x+dx[i], y+dy[i]));
                    visited[x+dx[i]][y+dy[i]] = 1;
                    dfs(x+dx[i], y+dy[i], colour);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }

        }
    }
}
