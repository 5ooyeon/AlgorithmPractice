package baekjoon;

import java.io.*;
import java.util.*;

public class 내리막길_1520 {

    static class Loc{
        int x, y;
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}, arr[];
    static Queue<Loc> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        

    }

}
