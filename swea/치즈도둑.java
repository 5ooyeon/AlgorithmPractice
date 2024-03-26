package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 치즈도둑
 */
public class 치즈도둑 {

    static int arr[][], visited[][], n;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <= t ; tc++) {
            n = Integer.parseInt(bf.readLine());

            int maxDay = 0;

            arr = new int[n][n];
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxDay = maxDay > arr[i][j] ? maxDay : arr[i][j];
                }
            }

            int ans = 0;

            for(int day = 1; day <= maxDay; day++) {
                visited = new int[n][n];
                int cheese = 0;
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++) {
                        if(visited[i][j]== 0 && arr[i][j]>day) {
                            cheese++;
                            visited[i][j] = 1;
                            getCheese(i, j, day);
                        }
                    }
                }

                ans = ans > cheese ? ans : cheese;
            }
            sb.append("#"+tc+" "+ans+"\n");

        }
        System.out.println(sb);
    }

    static void getCheese(int i, int j, int day) {
        for(int idx = 0;idx < 4;idx++) {
            try {
                if(visited[i+dx[idx]][j+dy[idx]] == 0 && arr[i+dx[idx]][j+dy[idx]]>day) {
                    visited[i+dx[idx]][j+dy[idx]] = 1;
                    getCheese(i+dx[idx], j+dy[idx], day);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}