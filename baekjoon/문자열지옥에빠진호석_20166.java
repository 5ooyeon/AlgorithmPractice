package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열지옥에빠진호석_20166 {

    static int N, M, K, dx[] = {-1, 0, 1, 0, 1, 1, -1, -1}, dy[] = {0, 1, 0, -1, 1, -1, 1, -1};
    static char[][] arr;
    static int[][][] memo;
    static String[] targets;

    static void input(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        targets = new String[K];
        for (int i = 0; i < K; i++) {
            targets[i] = bf.readLine();
        }
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();
        for (String tar : targets) {
            int len = tar.length();
            memo = new int[N][M][len];
            for (int[][] row : memo) {
                for (int[] col : row) {
                    java.util.Arrays.fill(col, -1);
                }
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == tar.charAt(0)) {
                        count += getCase(i, j, 0, tar);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static int getCase(int x, int y, int index, String tar) {
        if (index == tar.length() - 1) return 1;
        if (memo[x][y][index] != -1) return memo[x][y][index];
        int result = 0;
        for (int i = 0; i < 8; i++) {
            int nx = set(x + dx[i], N), ny = set(y + dy[i], M);
            if (arr[nx][ny] == tar.charAt(index + 1)) {
                result += getCase(nx, ny, index + 1, tar);
            }
        }
        return memo[x][y][index] = result;
    }

    static int set(int num, int range) {
        if (num >= range) return 0;
        if (num < 0) return range - 1;
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input(bf);
        solve();
    }
}
