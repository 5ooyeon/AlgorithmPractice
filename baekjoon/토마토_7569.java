package baekjoon;

import java.io.*;
import java.util.*;

public class 토마토_7569 {
    static int N, M, H, arr[][][], currTomato, wallCnt, ansDay;
    static class Tomato{
        int x, y, z;
        Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static Queue<Tomato> tomatos = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());

        currTomato = 0; wallCnt = 0; ansDay = 0;
        arr = new int[N][M][H];
        for(int k=0;k<H;k++) {
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<M;j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());

                    if(arr[i][j][k] == 1) {
                        tomatos.add(new Tomato(i, j, k));
                        currTomato++;
                    } else if(arr[i][j][k] == -1) {
                        wallCnt++;
                    }
                }
            }
        }

        while(currTomato != N*M*H - wallCnt && !tomatos.isEmpty()) {
            ansDay++; growingTomatos();

        }
        if(currTomato != N*M*H - wallCnt) {
            System.out.println(-1);
        } else {
            System.out.println(ansDay);
        }

    }

    static void growingTomatos() {
        Queue<Tomato> returnQueue = new ArrayDeque<>();
        while(!tomatos.isEmpty()) {
            Tomato tomato = tomatos.poll();
            for(int i=0;i<4;i++) {
                try {
                    if(arr[tomato.x+dx[i]][tomato.y+dy[i]][tomato.z] == 0) {
                        currTomato++;
                        arr[tomato.x+dx[i]][tomato.y+dy[i]][tomato.z] = 1;
                        returnQueue.add(new Tomato(tomato.x+dx[i], tomato.y+dy[i], tomato.z));
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            //상
            try {
                if(arr[tomato.x][tomato.y][tomato.z+1] == 0) {
                    currTomato++;
                    arr[tomato.x][tomato.y][tomato.z+1] = 1;
                    returnQueue.add(new Tomato(tomato.x, tomato.y, tomato.z+1));
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

            //하
            try {
                if(arr[tomato.x][tomato.y][tomato.z-1] == 0) {
                    currTomato++;
                    arr[tomato.x][tomato.y][tomato.z-1] = 1;
                    returnQueue.add(new Tomato(tomato.x, tomato.y, tomato.z-1));
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        tomatos = returnQueue;
    }
}
