package baekjoon;

import java.io.*;
import java.util.*;

public class 치즈_2636 {
    static class Loc {
        int x, y;
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Loc> Cheeze = new ArrayDeque<>();
    static int N, M, arr[][], dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1}, time, cheezeCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    Cheeze.offer(new Loc(i, j));
                }
            }
        }

        time = 0;
        while(!Cheeze.isEmpty()) {
            time++; cheezeCnt = Cheeze.size();
            meltingCheeze();
        }
        System.out.println(cheezeCnt+"\n"+time);
    }

    static void meltingCheeze() {
        Queue<Loc> returnQueue = new ArrayDeque<>();
        first: while(!Cheeze.isEmpty()) {
            Loc cheeze = Cheeze.poll();
            for(int idx=0;idx<4;idx++) {
                int x = cheeze.x+dx[idx], y = cheeze.y + dy[idx];
                System.out.println(isInRange(x, y));
                System.out.println(arr[x][y]);
                System.out.println(isHole(x, y));
                if(isInRange(x, y) && arr[x][y] == 0 && !isHole(x, y)) {
                    continue first;
                }
            }
            returnQueue.offer(cheeze);
        }
        Cheeze = returnQueue;
    }

    static boolean isHole(int i, int j) {
        for(int idx = 0;idx < 4; idx++) {
            int x = i+dx[idx], y = j+dy[idx];
            if(isInRange(x, y) && arr[x][y] == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isInRange(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }
}
