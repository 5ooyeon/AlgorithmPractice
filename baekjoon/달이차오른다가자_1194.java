package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달이차오른다가자_1194 {
    static class Loc {
        int x, y;

        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Minsik extends Loc {
        int key;
    
        Minsik(int x, int y, int key) {
            super(x, y);
            this.key = key;
        }

    }
    static int N, M, dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1}, key = 0;
    static char[][] arr;
    static Loc[] loc = new Loc[2];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        char[][] arr = new char[N][M];

        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
            for(int j=0;j<M;j++) {
                if(arr[i][j] == '0') {
                    loc[0] = new Loc(i, j);
                } else if(arr[i][j] == '1') {
                    loc[1] = new Loc(i, j);
                }
            }
        }

        int x = loc[0].x, y = loc[0].y;
        for(int i=0;i<4;i++) {
            int nx = x+dx[i], ny = y+dy[i];
            if(isInRange(nx, ny) && arr[nx][ny] != '#') {
                //갈 수 있는 곳. 1인지 .인지 열쇠인지 문인지 확인.
                if(arr[nx][ny] == '1') {

                } else if(arr[nx][ny] >= 'A') {

                } else if(arr[nx][ny] >= 'a') {

                }

                //민식이가 원래 있던 곳은 .으로 바꾸어주어야 한다.
            }
        }

    }

    static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
