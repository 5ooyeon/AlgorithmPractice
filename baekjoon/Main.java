package baekjoon;
    
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][]arr;
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    static int n;
    static boolean [][] check;
    static int sum ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            check = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split("");//입력받기 붙어있는 숫자열
                for (int j = 0; j < n; j++)
                    arr[i][j] = Integer.parseInt(input[j]);
            }sum = 0;
            dfs(n/2,n/2);
            System.out.println("#"+t+" "+sum);
        }
    }
    public static void dfs(int x, int y) {
        sum += arr[x][y];
        check[x][y] =true;
        for(int k = 0; k<4 ; k++){
            int idx = x+ dx[k];
            int idy = y+ dy[k];
            if(0 <= idx && idx < n && 0<=idy && idy < n && !check[idx][idy]) {
                dfs(idx,idy);
                
            }
        }
    }

}