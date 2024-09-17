package baekjoon;

import java.io.*;
import java.util.*;

public class 낚시왕_17143 {
    static int R, C, M;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
    static class Shark {
        int x, y, v, dir, size;

        Shark(int x, int y, int v, int dir, int size) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.dir = dir;
            this.size = size;
        }
    }
    static Shark[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(x, y, s, idx, z);
            map[x][y] = shark;
        }
        int ans = 0;
        for (int i = 0; i < C; i++) {
            // 1. 낚시왕이 있는 열에서 가장 가까운 상어 잡기
            catchShark: for (int j = 0; j < R; j++) {
                if (map[j][i] != null) {
                    ans += map[j][i].size;
                    map[j][i] = null;
                    break catchShark;
                }
            }

            if (i == C - 1) {
                System.out.println(ans);
                return;
            }

            // 2. 상어 이동
            Shark[][] newMap = new Shark[R][C];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] != null) {
                        Shark shark = map[r][c];
                        moveShark(shark);
                        // 3. 상어가 한 칸에 여러 마리면 크기 비교
                        if (newMap[shark.x][shark.y] == null || newMap[shark.x][shark.y].size < shark.size) {
                            newMap[shark.x][shark.y] = shark;
                        }
                    }
                }
            }
            map = newMap;
        }
    }

    // 상어의 이동 계산 최적화
    private static void moveShark(Shark shark) {
        int distance;
        if (shark.dir < 2) { // 위(0), 아래(1)
            distance = shark.v % ((R - 1) * 2);
        } else { // 오른쪽(2), 왼쪽(3)
            distance = shark.v % ((C - 1) * 2);
        }

        for (int t = 0; t < distance; t++) {
            if (!isInRange(shark.x + dx[shark.dir], shark.y + dy[shark.dir])) {
                shark.dir = (shark.dir + 1) % 2 == 0 ? shark.dir - 1 : shark.dir + 1;
            }
            shark.x += dx[shark.dir];
            shark.y += dy[shark.dir];
        }
    }

    private static boolean isInRange(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
    }
}
