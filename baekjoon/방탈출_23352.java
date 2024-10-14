
package baekjoon;

// import java.io.*;
// import java.util.*;

// public class 방탈출_23352 {
//     static class Loc {
//         int x, y, sum;

//         Loc(int x, int y) {
//             this.x = x;
//             this.y = y;
//         }
//     }
//     static int N, M, dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
//     public static void main(String[] args) throws IOException {
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(bf.readLine());
//         N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
//         int[][] arr = new int[N][M];

//         for(int i=0;i<N;i++) {
//             st = new StringTokenizer(bf.readLine());
//             for(int j=0;j<M;j++) {
//                 arr[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }
//         int maxlen = 0, ans = 0;
//         // for(int i=0;i<N;i++) {
//         //     for(int j=0;j<M;j++) {
//         //         if(arr[i][j] != 0) {
//                     int i=0, j=3;
//                     int len = 0;
//                     boolean[][] visited = new boolean[N][M];
//                     visited[i][j] = true;
//                     Queue<Loc> queue = new ArrayDeque<>();
//                     queue.offer(new Loc(i, j));
//                     while(!queue.isEmpty()) {
//                         len++;
//                         Queue<Loc> newQueue = new ArrayDeque<>();
//                         while(!queue.isEmpty()) {
//                             Loc loc = queue.poll();
//                             int X = loc.x, Y = loc.y;
//                             int min = Integer.MAX_VALUE;
//                             for(int idx= 0; idx<4;idx++) {
//                                 int XX = X+dx[idx], YY = Y+dy[idx];
//                                 if(isInRange(XX, YY) && !visited[XX][YY] && arr[XX][YY]!=0) {
//                                     min = Math.min(min, Math.abs(arr[XX][YY] - arr[X][Y]));
//                                 }
//                             }
//                             for(int idx= 0; idx<4;idx++) {
//                                 int XX = X+dx[idx], YY = Y+dy[idx];
//                                 if(isInRange(XX, YY) && Math.abs(arr[XX][YY] - arr[X][Y])==min && !visited[XX][YY] && arr[XX][YY] != 0) {
//                                     visited[XX][YY] = true;
//                                     newQueue.offer(new Loc(XX, YY));
//                                 }
//                             }
//                             if(newQueue.isEmpty()) {
//                                 if(maxlen < len) {
//                                     maxlen = len;
//                                     ans = arr[i][j] + arr[X][Y];
//                                 } else if(maxlen == len) {
//                                     ans = Math.max(ans, arr[i][j] + arr[X][Y]);
//                                 }
//                             }
                            
//                         }
//                         queue = newQueue;
//                     }
//         //         }
//         //     }
//         // }
//         System.out.println(ans);
//     }
//     private static boolean isInRange(int x, int y) {
//         return 0 <= x && x < N && 0 <= y && y < M;
//     }
// }
import java.util.*;

class info{
    int x;
    int y;
    int move;
    info(int x, int y, int move){
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
public class 방탈출_23352 {
    public static int N, M;
    public static int map[][];
    public static boolean check[][];
    
    public static int start;
    public static int route = 0;
    public static int ans=0;
    
    public static int xMove[] = {-1, 1, 0, 0};
    public static int yMove[] = {0, 0, -1, 1};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        check = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        
        // for(int i=0; i<N; i++){
        //     for(int j=0; j<M; j++){
        //         if(map[i][j] != 0){
                    check = new boolean[N][M];
                    check[0][1] = true;
                    start = map[0][1];
                    BFS(0, 1);
        //         }
        //     }
        // }
        System.out.println(ans);
    }
    public static void BFS(int xs, int ys){
        Queue<info> q = new LinkedList<>();
        
        q.add(new info(xs, ys, 0));
        
        while(!q.isEmpty()){
            
            info info = q.remove();
            int x = info.x;
            int y = info.y;
            int move = info.move;
            int end = map[x][y];
            
            if(move >= route){
                if(move > route){
                    ans = start + end;
                    System.out.println(xs+" "+ys);
                }else{
                    ans = Math.max(ans, start+end);
                    System.out.println(xs+" "+ys);
                }
                route = move;
            }
            
            for(int i=0; i<4; i++){
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];
                
                if(xTo<0 || yTo<0 || xTo>=N || yTo>=M) continue;
                if(check[xTo][yTo] || map[xTo][yTo]==0) continue;
                check[xTo][yTo] = true;
                
                q.add(new info(xTo, yTo, move+1));
            }
        }
    }
}