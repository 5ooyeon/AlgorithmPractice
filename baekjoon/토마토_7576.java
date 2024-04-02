package baekjoon;

import java.io.*;
import java.util.*;

public class 토마토_7576 {

    static int N, M, arr[][], tomatoCnt, ansDay, unav;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static class Tomato {
        int x, y;
        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Tomato> tomatos = new ArrayDeque();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        ansDay = 0; unav = 0; tomatoCnt = 0; int wallCnt = 0;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    tomatos.offer(new Tomato(i, j));
                    tomatoCnt++;
                }
                if(arr[i][j] == -1) {
                    wallCnt++;
                }
            }
        }
        while(tomatoCnt!= N*M-wallCnt) {
            ansDay++; growTomatos();
            if(unav == 1) {
                System.out.println(-1); System.exit(0);
            }
        }
        
        System.out.println(ansDay);

    }
    static void growTomatos() {
        Queue<Tomato> returnList = new ArrayDeque();
        int changeCnt = 0;

        while(!tomatos.isEmpty()) {
            Tomato tomato = tomatos.poll();
            for(int i=0;i<4;i++) {
                try {
                    if(arr[tomato.x+dx[i]][tomato.y+dy[i]] == 0) {
                        changeCnt++; tomatoCnt++;
                        arr[tomato.x+dx[i]][tomato.y+dy[i]] = 1;
                        returnList.offer(new Tomato(tomato.x+dx[i], tomato.y+dy[i]));
                    }
                } catch (Exception e) {
                }
            }
        }

        if(changeCnt == 0) {
            unav = 1;
        }
        tomatos = returnList;
    }
}
