package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {
    static int N, B, height[], max;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc<= t; tc++) {
            sb.append("#"+tc+" ");

            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); B = Integer.parseInt(st.nextToken());
            height = new int[N];
            st = new StringTokenizer(bf.readLine());

            int totalHeight = 0; max = 0;

            for(int i=0;i<N;i++) {
                height[i] = Integer.parseInt(st.nextToken());
                totalHeight += height[i];

                if(max==0 && totalHeight >= B) {
                    max = totalHeight;
                }
            }
            Arrays.sort(height);
            dfs(0, 0);
            sb.append(max - B).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int idx, int total) {
        if(total >= max) {
            return;
        }
        if(total >= B) {
            max = total;
            return;
        }
        for(int i = idx; i < N;i++) {
            dfs(i+1, total+height[i]);
        }
    }
}
