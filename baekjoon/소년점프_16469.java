package baekjoon;

import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class 소년점프_16469 {
    static class Loc {
        int x, y;

        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            String line = bf.readLine();
            for (int j = 1; j <= C; j++) {
                arr[i][j] = line.charAt(j - 1);
            }
        }

        Queue<Loc>[] queue = new ArrayDeque[3];
        boolean[][][] visited = new boolean[R + 1][C + 1][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(bf.readLine());
            Loc loc = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            queue[i] = new ArrayDeque<>();
            queue[i].add(loc);
            visited[loc.x][loc.y][i] = true;
        }

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        int cnt = 0;
        while (!queue[0].isEmpty() && !queue[1].isEmpty() && !queue[2].isEmpty()) {
            cnt++;

            for (int i = 0; i < 3; i++) {
                int size = queue[i].size();
                for (int j = 0; j < size; j++) {
                    Loc loc = queue[i].poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = loc.x + dr[d];
                        int ny = loc.y + dc[d];
                        if (isInRange(nx, ny, R, C) && arr[nx][ny] == '0' && !visited[nx][ny][i]) {
                            queue[i].add(new Loc(nx, ny));
                            visited[nx][ny][i] = true;
                        }
                    }
                }
            }

            int rs = 0;
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (visited[i][j][0] && visited[i][j][1] && visited[i][j][2]) {
                        rs++;
                    }
                }
            }

            if (rs != 0) {
                System.out.println(cnt);
                System.out.println(rs);
                return;
            }
        }

        System.out.println(-1);
    }

    static boolean isInRange(int x, int y, int R, int C) {
        return x > 0 && y > 0 && x <= R && y <= C;
    }
}
