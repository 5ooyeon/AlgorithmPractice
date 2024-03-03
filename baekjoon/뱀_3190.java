package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 뱀_3190
 */
public class 뱀_3190 {

    static class Coor{
        int x; int y;
        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, arr[][];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        int temp = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=0;i<temp;i++) {
            st = new StringTokenizer(bf.readLine());
            arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        
        Deque<Coor> snake = new ArrayDeque<>();
        LinkedList<Coor> timeData = new LinkedList<>();
        int dataCnt = Integer.parseInt(bf.readLine());
        for(int i=0;i<dataCnt;i++) {
            st = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(st.nextToken());
            int dir = 0;
            switch (st.nextToken()) {
                case "L":
                    dir = -1;
                    break;
            
                default:
                    dir = 1;
                    break;
            }
            timeData.add(new Coor(t, dir));
        }

        int x = 0, y = 0, time = 1, dr = 1;
        arr[x][y] = -1;
        
        snake.addFirst(new Coor(x, y));

        while(true) {
            //벽인지 확인
            if(x+dx[dr] >= N || x+dx[dr] < 0 || y+dy[dr] >=N || y+dy[dr] <0) {
                // System.out.println("out of bound");
                break;
            }

            //가는 곳이 본인의 몸인지 확인
            if(arr[x+dx[dr]][y+dy[dr]] == -1) {
                // System.out.println("snake!");
                break;
            } else if(arr[x+dx[dr]][y+dy[dr]] != 1) {
                //가는 곳에 사과가 없다면 tail 하나 끊김
                Coor coor = snake.removeLast();
                arr[coor.x][coor.y] = 0;
            }
            //가는 방향으로 덱에 좌표값 넣어주기
            x += dx[dr]; y += dy[dr];
            arr[x][y] = -1;
            snake.addFirst(new Coor(x, y));
            
            //timeData에 있는 시간값과 같다면 방향바꿔주기
            if(timeData.size()!=0 && time == timeData.getFirst().x) {
                dr += timeData.removeFirst().y;
                dr%=4;
                if(dr < 0) {
                    dr += 4;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}