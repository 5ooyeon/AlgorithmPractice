package A형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄기세포배양_풀이 {
    static int N,M,K;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Cell> queue;
    static int[] dr = {-1, 0, 1, 0};


    //세포 정보 관리용 클래스
    static class Cell{
        int r, c; //위치 정보
        int status; //상태 정보:: 0:비활성, 1:활성, 2:죽은세포
        int life; //생명력 수치
        int time; //상태 변경 용 시간 흐름 확인

        Cell(int r, int c, int life) {
            this.r = r;
            this.c = c;
            this.life = life;
            this.time = life;
        }

        //시간마다 상태 정보 변경하는 메서드
        void step() {
            switch (status) {
                case 0: //비활성화 상태
                    if(--time==0) {
                    //생명력이 0이 된다면 활성화로 바꾸기
                        this.status = 1;
                    }
                    break;
                case 1: //활성화 상태
                    if(++time == life) {
                        //생명력과 같아지면 죽은 세포로 바꿔주기
                        this.status = 2;
                    }
                default:
                    break;
            }
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(bf.readLine());

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            //배양 용기 만들기
            map = new int[N+K+1][M+K+1];
            visited = new boolean[N+K+1][M+K+1];

            //관리할 세포들을 담을 큐 생성
            queue = new LinkedList<>();

            //세포 배양 정보 받기, 세포 배양 위치를 중앙으로 잡아주기
            for(int r = K/2+1; r < N+K/2+1; r++) {
                st = new StringTokenizer(bf.readLine());
                for(int c = K/2+1; c < M+K/2+1; c++) {
                    //이 위치에 있는 세포의 생명력
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp != 0) {
                        map[r][c] = temp;
                        visited[r][c] = true;
                        queue.add(new Cell(r, c, temp)); //초기 세포 정보 큐에 넣어주기
                    }
                }
            }
            solve();
            System.out.println("#"+tc+" "+queue.size());

        }
    }

    //매시간 세포 배양해주기: BFS 베이스
    private static void solve() {
        while(K-->0) {
            //배양 전처리
            //현재 가진 정보로 번식을 했을 때, 각 map에 가장 큰 생명력 저장
            for(Cell test : queue) {
                if(test.status == 1) {
                    for(int d=  0; d< 4 ; d++) {
                        int nr = test.r + dr[d];
                        int nc = test.c + dr[d];
                        
                        //방문 처리 => 이전 시간에 번식된 곳
                        if(visited[nr][nc]) {
                            continue;
                        }

                        //배양 용기의 세포 생명력만 갱신: 수치가 가장 높은 값으로
                        if(map[nr][nc]<test.life) {
                            map[nr][nc] = test.life;
                        }
                    }
                }
            }


            //이번 시간에 확인한 세포 수
            int size = queue.size();

            //현재 시간에 확인할 세포 만큼 배양
            for(int s=0;s<size;s++) {
                Cell c = queue.poll();

                //세포
                if(c.status == 1) {
                    for(int d= 0; d < 4; d++) {

                        int nr = c.r+dr[d];
                        int nc = c.c+dr[d];

                        if(visited[nr][nc]) {
                            continue;
                        }

                        //배양이 안된 곳에 번식
                        queue.add(new Cell(nr, nc, map[nr][nc]));
                        visited[nr][nc] = true;
                    }
                }

                //세포 상태 변화시키기
                c.step();

                if(c.status == 2) {
                    //죽은 세포면 continue
                    continue;
                }

                //활성화, 비활성화 상태의 세포는 다음 시간에 배양할 수 있게 큐에 넣어놓기.
                queue.add(c);
            }
        }
    }
}
