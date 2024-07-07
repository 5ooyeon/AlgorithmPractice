// package baekjoon;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayDeque;
// import java.util.ArrayList;
// import java.util.PriorityQueue;
// import java.util.Queue;
// import java.util.StringTokenizer;

// public class 연구소_14502 {
//     static class Loc{
//         int x;
//         int y;

//         Loc(int x, int y) {
//             this.x = x;
//             this.y = y;
//         }

//     }
//     static int arr[][], N, M, wall, areaCnt, dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1}, ans;
//     static boolean visited[][];
//     static ArrayList<Loc> virus = new ArrayList<>();
//     public static void main(String[] args) throws IOException {
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(bf.readLine());
//         N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        
//         arr = new int[N][M]; visited = new boolean[N][M]; wall = 0; areaCnt = 0; ans = 0;

//         for(int i=0;i<N;i++) {
//             st = new StringTokenizer(bf.readLine());
//             for(int j=0;j<M;j++) {
//                 arr[i][j] = Integer.parseInt(st.nextToken());

//                 if(arr[i][j] == 2) {
//                     virus.add(new Loc(i, j));
//                 } else if(arr[i][j] == 1) {
//                     wall++;
//                 }
//             }
//         }

//         setWalls(0);

//         System.out.println(ans);
//     }
//     private static void setWalls(int cnt) {
//         if(cnt == 3) {
//             countArea();
//         }

//         for(int i=0;i<N;i++) {
//             for(int j=0;j<M;j++) {
//                 if(arr[i][j] == 0) {
//                     arr[i][j] = 1;
//                     setWalls(cnt+1);
//                     arr[i][j] = 0;
//                 }
//             }
//         }
//     }

//     private static void countArea() {
//         for(int i=0;i<virus.size();i++) {
//             Queue<Loc> queue = new ArrayDeque<>();
//             queue.offer(virus.get(i));
//             bfs(queue);
//         }

//         ans = Math.max(ans, N*M - (areaCnt+wall+3+virus.size()));

//     }

//     private static void bfs(Queue<Loc> queue) {
//         while(!queue.isEmpty()) {
//             Loc loc = queue.poll();

//             for(int i=0;i<4;i++) {
//                 int x = loc.x+dx[i], y = loc.y+dy[i];
//                 if(isInRange(x, y) && arr[x][y] == 0 && !visited[x][y]) {
//                     areaCnt++; visited[x][y] = true;
//                     queue.offer(new Loc(x, y));
//                 }
//             }

//         }
//     }
//     private static boolean isInRange(int x, int y) {
//         return 0 <= x && x < N && 0 <= y && y < M;
//     }
// }
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {
    static class Loc {
        int x;
        int y;

        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr, tempArr;
    static int N, M, wall, ans;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static ArrayList<Loc> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        wall = 0;
        ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virus.add(new Loc(i, j));
                } else if (arr[i][j] == 1) {
                    wall++;
                }
            }
        }

        setWalls(0, 0);
        System.out.println(ans);
    }

    private static void setWalls(int cnt, int start) {
        if (cnt == 3) {
            simulate();
            return;
        }

        for (int i = start; i < N * M; i++) {
            int x = i / M;
            int y = i % M;
            if (arr[x][y] == 0) {
                arr[x][y] = 1;
                setWalls(cnt + 1, i + 1);
                arr[x][y] = 0;
            }
        }
    }

    private static void simulate() {
        tempArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }

        for (Loc v : virus) {
            spreadVirus(v);
        }

        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempArr[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        ans = Math.max(ans, safeArea);
    }

    private static void spreadVirus(Loc start) {
        Queue<Loc> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Loc loc = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = loc.x + dx[i];
                int y = loc.y + dy[i];
                if (isInRange(x, y) && tempArr[x][y] == 0) {
                    tempArr[x][y] = 2;
                    queue.offer(new Loc(x, y));
                }
            }
        }
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}

