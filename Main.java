import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[][], dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1}, sum, cost;
    static boolean visited[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc<=t; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); M =Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    getSum(i, j);
                }
            }
            
            
        }
    }
    
    static void getSum(int x, int y) {
        int k = 0;
        int benefit = arr[x][y] == 1 ? M - 1 : 0;
        while(true) {
            k++; //k==2
            sum = 0; cost = 0;
            dfs(k, x, y, 0);
            benefit = Math.max(sum - cost, benefit);
            
        }
    }

    static void dfs(int k, int x, int y, int depth) {
        if(depth == k) return;
        for(int i=0;i<4;i++) {
            if(isInRange(x+dx[i], y+dy[i])) {
                visited[x+dx[i]][y+dy[i]] = true; cost++;
                if(arr[x+dx[i]][y+dy[i]] == 1) sum++;
                dfs(k, x+dx[i], y+dy[i], depth+1);
            }
        }
    }

    static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N && !visited[x][y];
    }
}