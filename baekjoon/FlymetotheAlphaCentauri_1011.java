package baekjoon;

import java.io.*;
import java.util.*;

public class FlymetotheAlphaCentauri_1011 {
    static int x, y, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for(int tc =1; tc<=t;tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken())+1; y = Integer.parseInt(st.nextToken())-1;
            ans = 2;
            if(y-x<=0) {
                System.out.println(y-x+2); continue;
            }
            dp(1);
            System.out.println(ans);
        }
    }
    static void dp(int movement) {
        int left = y - x;
        if(left >= movement -1 && left <= movement + 1) {
            ans++;
            return;
        }
        ans++; x+= movement+1; dp(movement+1);
    }
}
