package baekjoon;

import java.io.*;
import java.util.*;

public class 로봇청소기_4991 {
    static int n, m;
    static char[][] arr;
    static Loc robot;
    static List<Loc> dirt;
    static int[][] distances;
    static int INF = 987654321;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Loc {
        int x, y;

        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                System.out.println(sb);
                System.exit(0);
            }

            arr = new char[n][m];
            dirt = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr[i] = bf.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 'o') {
                        robot = new Loc(i, j);
                    } else if (arr[i][j] == '*') {
                        dirt.add(new Loc(i, j));
                    }
                }
            }

            if (!calculateDistances()) {
                sb.append("-1\n");
                continue;
            }

            int result = solve();

            sb.append(result).append("\n");
        }
    }

    static boolean calculateDistances() {
        int pointCount = dirt.size() + 1;
        distances = new int[pointCount][pointCount];

        List<Loc> allPoints = new ArrayList<>(dirt);
        allPoints.add(0, robot);

        for (int i = 0; i < pointCount; i++) {
            int[][] dist = bfs(allPoints.get(i));
            for (int j = 0; j < pointCount; j++) {
                distances[i][j] = dist[allPoints.get(j).x][allPoints.get(j).y];
                if (distances[i][j] == -1) {
                    distances[i][j] = INF; 
                }
            }
        }

        for (int i = 1; i < pointCount; i++) {
            if (distances[0][i] == INF) {
                return false;
            }
        }
        return true;
    }

    static int[][] bfs(Loc start) {
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<Loc> queue = new LinkedList<>();
        queue.add(start);
        dist[start.x][start.y] = 0;

        while (!queue.isEmpty()) {
            Loc cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] != 'x' && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    queue.add(new Loc(nx, ny));
                }
            }
        }

        return dist;
    }

    static int solve() {
        int dirtyCount = dirt.size();
        int[][] dp = new int[1 << (dirtyCount + 1)][dirtyCount + 1];

        for (int[] row : dp) Arrays.fill(row, INF);
        dp[1][0] = 0; // Starting from the robot's position

        for (int mask = 1; mask < (1 << (dirtyCount + 1)); mask++) {
            for (int i = 0; i <= dirtyCount; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j <= dirtyCount; j++) {
                        if ((mask & (1 << j)) == 0) {
                            dp[mask | (1 << j)][j] = Math.min(dp[mask | (1 << j)][j], dp[mask][i] + distances[i][j]);
                        }
                    }
                }
            }
        }

        int result = INF;
        for (int i = 1; i <= dirtyCount; i++) {
            result = Math.min(result, dp[(1 << (dirtyCount + 1)) - 1][i]);
        }

        return result == INF ? -1 : result;
    }
}
