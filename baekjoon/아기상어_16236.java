package baekjoon;

import java.io.*;
import java.util.*;

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
    static PriorityQueue<Info> sharkList = new PriorityQueue<>();
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
                    sharkList.add(new Info(i, j, arr[i][j]));
                }


                if(arr[i][j] == 9) {
                    //아기상어위치 업데이트
                    babyShark = new Info(i, j, 2);
                }
            }
        }

        //거리 순으로 상어 정보 담을 pq만들기 
        PriorityQueue<Info> sharks = new PriorityQueue<>(new Comparator<Info>() {

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
        //0은 빈칸, 1,2,3,4,5,6 물고기 크기, 9는 아기상어

        whole : while(true) {
            //sharklist중 babyshark보다 사이즈가 작은 상어들(먹을 수 있는 상어)을 sharks에 넣기
            while(!sharkList.isEmpty() && sharkList.peek().size < babyShark.size) {
                Info shark = sharkList.poll();
                shark.distance = getDistance(shark);
                sharks.offer(shark);
            }

            //몇번 먹었는지 체크
            int eatingCnt = babyShark.size;
            // System.out.println("now eatingCnt: "+eatingCnt+", time: "+time);
            while(eatingCnt != 0 && !sharks.isEmpty()) {
                Info eatenShark = sharks.poll();

                if(eatenShark.distance == Integer.MAX_VALUE) {
                    //먹을 수 있는 상어가 없는 상태
                    break whole;
                }
                eatingCnt--;
                // System.out.println("Now eating: "+eatenShark.toString());
                arr[babyShark.x][babyShark.y] = 0;
                babyShark.x = eatenShark.x;
                babyShark.y = eatenShark.y;
                time += eatenShark.distance;

                //현재 babyshark의 위치 기준 가까운 순서 업데이트
                int cnt = sharks.size();
                // PriorityQueue<Info> temp = new PriorityQueue<>(new Comparator<Info>() {

                //     @Override
                //     public int compare(Info o1, Info o2) {
                //         if(o1.distance == o2.distance) {
                //             if(o1.x == o2.x) {
                //                 return o1.y - o2.y;
                //             }
                //             return o1.x - o2.x;
                //         }
                //         return o1.distance - o2.distance;
                //     }
                    
                // });
                // while(!sharks.isEmpty()) {
                //     Info updateShark = sharks.poll();
                //     updateShark.distance = getDistance(updateShark);
                //     temp.offer(updateShark);
                // }
                // sharks = temp;
            // sharks 업데이트 부분 수정
                PriorityQueue<Info> temp = new PriorityQueue<>(new Comparator<Info>() {
                    @Override
                    public int compare(Info o1, Info o2) {
                        if (o1.distance == o2.distance) {
                            if (o1.x == o2.x) {
                                return o1.y - o2.y;
                            }
                            return o1.x - o2.x;
                        }
                        return o1.distance - o2.distance;
                    }
                });

                while (!sharks.isEmpty()) {
                    Info updateShark = sharks.poll();
                    updateShark.distance = getDistance(updateShark);
                    temp.offer(updateShark);
                }
                sharks.clear();
                sharks.addAll(temp);

            
            }

            if(eatingCnt !=0) {
                // System.out.println(eatingCnt);
                break whole;//끝
            }

            babyShark.size++;
            while(!sharks.isEmpty()) {
                Info s = sharks.poll();
                sharkList.offer(s);
            }
            System.out.println(babyShark.size);
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
        // System.out.println(x+" "+y);
        if(x == babyShark.x && y == babyShark.y) {
            cnt = cnt < dis ? cnt : dis;
            return;
        }

        //아기상어보다 사이즈가 크면 못지나감.
        if(cnt <= dis || (arr[x][y] > babyShark.size && arr[x][y] != 9)) {
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
