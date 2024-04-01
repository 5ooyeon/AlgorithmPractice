package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {

    static class Info implements Comparable<Info>{
        int x, y, size, distance;

        Info(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size =size;
            this.distance = -1;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.size, o.size);
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "("+x+", "+y+") "+size+", "+distance;
        }
    }

    static int N, arr[][], time, cnt, visited[][];
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    static PriorityQueue<Info> pq = new PriorityQueue<>();
    static Info babyShark;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        time = 0;

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());

                if(arr[i][j] >0 && arr[i][j] < 7) {
                    pq.add(new Info(i, j, arr[i][j]));
                }


                if(arr[i][j] == 9) {
                    //아기상어위치 업데이트
                    babyShark = new Info(i, j, 2);
                }
            }
        }

        //상어 정보 담을 list만들기
        Queue<Info> sharks = new ArrayDeque<>();
        //0은 빈칸, 1,2,3,4,5,6 물고기 크기, 9는 아기상어

        //size up 하면 다시 실행할 while문
        first : while(!pq.isEmpty()) {

            //본인보다 작은 크기의 상어들을 poll
            while(!pq.isEmpty() && pq.peek().size < babyShark.size) {
                Info info = pq.poll();
                System.out.println(info.toString());
                sharks.add(info);
            }

            int eatingCount = 0;

            //거리별 정렬해줄 pq 만들기
            PriorityQueue<Info> eatingOrder = new PriorityQueue<>(new Comparator<Info>() {

                @Override
                public int compare(Info o1, Info o2) {
                    if(o1.distance == o2.distance) {
                        if(o1.x == o2.x) {
                            return o1.y - o2.y;
                        }
                        return o1.x - o2.x;
                    }
                    return o1.distance - o2.distance;
                }
                
            });



            second : while(true) {

                //먹을 상어들 넣어주기.
                while(!sharks.isEmpty()) {
                    Info shark = sharks.poll();
                    System.out.println(shark.toString());
                    //거리 업데이트 후 eatingorder에 넣어주기
                    shark.distance = getDistance(shark);
                    System.out.println(shark.toString());
                    eatingOrder.offer(shark);
                }

                //먹을 상어가 없는경우 break
                if(eatingOrder.peek().distance == Integer.MAX_VALUE) {
                    System.out.println("111");
                    break first;
                }
                System.out.println("222");
                //먹기!

                Info eatenShark = eatingOrder.poll();
                
                time += eatenShark.distance;
                System.out.println("distance is : "+eatenShark.distance+", time is :"+time);
                babyShark.x = eatenShark.x;
                babyShark.y = eatenShark.y;
                eatingCount++;

                //eatingOrder에 있는거 다 sharks에 넣어주기
                while(!eatingOrder.isEmpty()) {
                    sharks.offer(eatingOrder.poll());
                }

                //먹은 횟수가 상어크기만큼 됐다면
                if(eatingCount == babyShark.size) {
                    babyShark.size++;
                    //여기서 모든 eatingOrder에 있는 것들을 sharks에 옮기는 작업 필요.


                    break second;
                }

                if(sharks.isEmpty()) {
                    break first;
                }

            }

        }
        System.out.println(time);

    }

    static int getDistance(Info shark) {
        //dfs로 양방향 탐색하며 최단경로 찾기.
        //아기상어 기준으로 shark의 x,y까지.
        cnt = Integer.MAX_VALUE;
        visited = new int[N][N];
        visited[shark.x][shark.y] = 1;
        dfs(shark.x, shark.y, 0);
        return cnt;
    }

    static void dfs(int x, int y, int dis) {
        if(x == babyShark.x && y == babyShark.y) {
            cnt = cnt < dis ? cnt : dis;
            return;
        }

        //아기상어보다 사이즈가 크면 못지나감.
        if(cnt <= dis || arr[x][y] > babyShark.size) {
            return;
        }

        for(int i=0;i<4;i++) {
            try {
                if(arr[x+dx[i]][y+dy[i]]==9 || (arr[x+dx[i]][y+dy[i]] <= babyShark.size && visited[x+dx[i]][y+dy[i]] ==0)) {
                    visited[x+dx[i]][y+dy[i]] = 1;
                    dfs(x+dx[i], y+dy[i], dis+1);
                    visited[x+dx[i]][y+dy[i]] = 0;
                }
            } catch (Exception e) {

            }
        }

    }
}
