package baekjoon;

import java.io.*;
import java.util.*;

public class 아기상어2트_16236 {

    static class Shark implements Comparable<Shark> {
        int x, y, size, distance, eaten;

        Shark(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.distance = -1;
            eaten = 0;
        }

        @Override
        public int compareTo(Shark o) {
            return Integer.compare(this.size, o.size);
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "(" + x + ", " + y + ") " + size + ", " + distance;
        }
        
        // Shark에 grow 함수 추가
        // 먼저 먹고 내 몸집만큼 먹게되면 size up 후 eaten = 0
        public void grow() {
            eaten++;
            if(eaten == size) {
                size++;
                eaten = 0;
            }            
        }
    }

    // dp쓰면 visit배열 안써도됩니다. -> visit역할까지 해줘서
    static int N, arr[][], time, cnt, /* visited[][], */ dp[][];
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    static PriorityQueue<Shark> sharkList = new PriorityQueue<>();
    static Shark babyShark;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        time = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] > 0 && arr[i][j] < 7) {
                    sharkList.add(new Shark(i, j, arr[i][j]));
                }

                if (arr[i][j] == 9) {
                    // 아기상어위치 업데이트
                    babyShark = new Shark(i, j, 2);
                }
            }
        }

        // 거리 순으로 상어 정보 담을 pq만들기
        PriorityQueue<Shark> sharks = new PriorityQueue<>(new Comparator<Shark>() {

            @Override
            public int compare(Shark o1, Shark o2) {
                if (o1.distance == o2.distance) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
                return o1.distance - o2.distance;
            }

        });
        // 0은 빈칸, 1,2,3,4,5,6 물고기 크기, 9는 아기상어
        // 맨 처음에 전 맵을 탐색해본다 -> 그 후 getDistance는 dp값을 반환만 하면 된다.
        dp = new int[N][N];
        dfs(babyShark.x, babyShark.y, 0);
        whole: while (true) {
            // sharklist중 babyshark보다 사이즈가 작은 상어들(먹을 수 있는 상어)을 sharks에 넣기            
            while (!sharkList.isEmpty() && sharkList.peek().size < babyShark.size) {
                Shark shark = sharkList.poll();
                shark.distance = getDistance(shark);
                sharks.offer(shark);
            }

            // 몇번 먹었는지 체크
            if(sharks.isEmpty())
                break whole;
            Shark eatenShark = sharks.poll();

            if (eatenShark.distance == Integer.MAX_VALUE) {
                // 먹을 수 있는 상어가 없는 상태
                break whole;
            }
            arr[babyShark.x][babyShark.y] = 0;
            babyShark.x = eatenShark.x;
            babyShark.y = eatenShark.y;
            time += eatenShark.distance;
            
            //왜 원래 코드 한타임에 많은 물고기를 드셨어요..?
            //한타임에는 물고기 하나만 드세요.. 몸 클때까지 드시지 마시고.. 네.......................
            babyShark.grow();
            

            // sharks 업데이트 부분 수정
            PriorityQueue<Shark> temp = new PriorityQueue<>(new Comparator<Shark>() {
                @Override
                public int compare(Shark o1, Shark o2) {
                    if (o1.distance == o2.distance) {
                        if (o1.x == o2.x) {
                            return o1.y - o2.y;
                        }
                        return o1.x - o2.x;
                    }
                    return o1.distance - o2.distance;
                }
            });
            

            //아기상어의 위치가 바뀌면
            //새로운 dp를 만들어야 하므로 새 dp 배열을 만들고
            //dp배열 만드는 작업 -> dfs
            dp = new int[N][N];
            dfs(babyShark.x, babyShark.y, 0);
            while (!sharks.isEmpty()) {
                Shark updateShark = sharks.poll();
                updateShark.distance = getDistance(updateShark);
                temp.offer(updateShark);
            }
            sharks.clear();
            sharks.addAll(temp);

            
            
            while (!sharks.isEmpty()) {
                Shark s = sharks.poll();
                sharkList.offer(s);
            }
//            System.out.println(babyShark.size);
        }
        System.out.println(time);
    }

    // 이 shark는 먹이다.
    static int getDistance(Shark shark) {
        // dfs로 양방향 탐색하며 최단경로 찾기.
        // 아기상어 기준으로 shark의 x,y까지.
        cnt = Integer.MAX_VALUE;
        if (dp[shark.x][shark.y] != 0)
            return dp[shark.x][shark.y];
        return cnt;
    }

    // 전맵 탐색하여 dp배열을 채우는 작업
    static void dfs(int x, int y, int dis) {

        // 만약 현재 위치의 dp값이 dis보다 작다면 지금 가는 길은 최적이 아니므로 return
        if (dp[x][y] != 0 && dp[x][y] <= dis) {
            return;
        }
        // 위에서 return 되지 않았다면 지금 가는 길은 최적이므로 dp값에 저장
        dp[x][y] = dis;

        // 아기상어보다 사이즈가 크면 못지나감.
        if ((arr[x][y] > babyShark.size && arr[x][y] != 9)) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            try {
                if (arr[x + dx[i]][y + dy[i]] <= babyShark.size) {
                    dfs(x + dx[i], y + dy[i], dis + 1);
                }
            } catch (Exception e) {

            }
        }

    }

    static void printMap(int x, int y) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (x != i || y != j)
                    System.out.print(arr[i][j] + " ");
                else
                    System.out.print(9 + " ");
            }
            System.out.println();
        }
    }

    static void printDp(int[][] dp) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
