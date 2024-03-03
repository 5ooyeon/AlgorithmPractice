package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기123_9095 {
    static int n, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for(int tc =0; tc<t; tc++) {
            n = Integer.parseInt(bf.readLine());
            ans = 0;
            dfs(n);
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());

    }
    static void dfs(int num) {
        if(num == 0) {
            ans++;
        }
        if(num <= 0) {
            return;
        }
        for(int i=1;i<=3;i++) {
            dfs(num-i);
        }
    }
}
