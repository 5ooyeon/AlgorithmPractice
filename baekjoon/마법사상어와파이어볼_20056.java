package baekjoon;

import java.io.*;
import java.util.*;

public class 마법사상어와파이어볼_20056 {
    static class FireBall {
        int x, y, weight, speed, dir;
        FireBall(int x, int y, int weight, int speed, int dir) {
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.speed = speed;
            this.dir = dir;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "("+x+", "+y+"), weight: "+weight+", speed: "+speed+", dir: "+dir;
        }
    }
    static int N, M, K;
    static Queue<FireBall>[][] arr, newArr;
    static int[][] coor = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        
        arr = new ArrayDeque[N][N];
        
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken())-1, y = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken()), speed = Integer.parseInt(st.nextToken()), dir =Integer.parseInt(st.nextToken());
            
            if(arr[x][y] == null) arr[x][y] = new ArrayDeque<>();
            arr[x][y].add(new FireBall(x, y, weight, speed, dir));
        }

        for(int time=0;time <K;time++) {

            newArr = new ArrayDeque[N][N];
            // FireBall[][] returnArr = new FireBall[N][N];
            System.out.println("time is "+time);
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(arr[i][j] != null && arr[i][j].size() != 0) {
                        moveFireBall(i, j);
                    }
                }
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(newArr[i][j] == null || newArr[i][j].size()==1) continue;
                    int totalWeight = 0, totalSpeed = 0, cnt = newArr[i][j].size(), dirCheck = newArr[i][j].peek().dir%2;
                    // Queue<FireBall> tempQueue = new ArrayDeque<>();
                    boolean sameDir = true; 
                    while(!newArr[i][j].isEmpty()) {
                        FireBall fb = newArr[i][j].poll();
                        totalWeight += fb.weight; totalSpeed += fb.speed;
                        if(fb.dir%2 != dirCheck) sameDir = false;
                    }
                    if(totalWeight/5 == 0) continue;
                    for(int dir = sameDir ? 0 : 1; dir < 8; dir+=2) {
                        newArr[i][j].offer(new FireBall(i, j, totalWeight/5, totalSpeed/cnt, dir));
                    }
                }
            }
            arr = newArr;

        }
        int ans = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(arr[i][j] != null) {
                    while(!arr[i][j].isEmpty()) {
                        ans += arr[i][j].poll().weight;
                    }
                }
            }
        }
        System.out.println(ans);

    }


    static void moveFireBall(int x, int y) {
        while(!arr[x][y].isEmpty()) {
            FireBall fb = arr[x][y].poll();
            System.out.println("bef:"+ fb.toString());
            FireBall refb = new FireBall(fb.x, fb.y, fb.weight, fb.speed, fb.dir);
            int time = fb.speed;

            for(int i=0;i<time;i++) {
                refb.x += coor[fb.dir][0];
                refb.y += coor[fb.dir][1];
                
                if(refb.x > N-1) {
                    refb.x -= N;
                }
                if(refb.x < 0) {
                    refb.x += N;
                }
                if(refb.y > N-1) {
                    refb.y -= N;
                }
                if(refb.y < 0) {
                    refb. y += N;
                }
            }
    
            if(newArr[refb.x][refb.y] == null) {
                newArr[refb.x][refb.y] = new ArrayDeque<>();
            }
            System.out.println(refb.toString());
            newArr[refb.x][refb.y].add(refb);
            // int nx = (x + (coor[fb.dir][0] * fb.speed)) % N;
            // int ny = (y + (coor[fb.dir][1] * fb.speed)) % N;
            // if (nx < 0) nx += N;
            // if (ny < 0) ny += N;

            // if(newArr[nx][ny] == null) {
            //     newArr[nx][ny] = new ArrayDeque<>();
            // }

            // FireBall newFb = new FireBall(nx, ny, fb.weight, fb.speed, fb.dir);

            // newArr[nx][ny].add(newFb);
        }
    }
}
