package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 인내의도미노장인호석_20165 {
    static BufferedReader bf;
    static StringTokenizer st;
    static int N, M, initArr[][], R, ans;
    static boolean fallen[][];
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

    static void input() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            st = new StringTokenizer(bf.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        initArr = new int[N][M];
        fallen = new boolean[N][M];
        ans = 0;

        for(int i=0;i<N;i++) {
            try {
                st = new StringTokenizer(bf.readLine());

                for(int j=0;j<M;j++) {
                    initArr[i][j] = Integer.parseInt(st.nextToken());
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    static void output() {
        System.out.println(ans);
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                System.out.print(fallen[i][j] ? "F " : "S ");
            }
            System.out.println();
        }
    }

    static void solve() {
        while(R > 0) {
            R--;

            try {
                st = new StringTokenizer(bf.readLine());
                push(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, st.nextToken().charAt(0));

                st = new StringTokenizer(bf.readLine());
                pick(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    static void push(int x, int y, char dir) {
        if(fallen[x][y]) {
            return;
        }

        int length = initArr[x][y]-1;
        ans++;

        int X = x, Y = y;
        int i = 0;
        switch (dir) {            
            case 'N':
                i = 0;
                break;
            case 'E':
                i = 1;
                break;
            case 'S':
                i = 2;
                break;
            default:
                i = 3;
                break;
        }

        while(length>0 && isInRange(X+dx[i], Y+dy[i])) {
            length--;
            if(fallen[X+=dx[i]][Y+=dy[i]]) {
                continue;
            }
            fallen[X][Y] = true;
            ans++;
            int newLength = initArr[X][Y]-1;
            length = Math.max(length, newLength);
        }

    }

    static void pick(int x, int y) {
        fallen[x][y] = false;
    }

    static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
