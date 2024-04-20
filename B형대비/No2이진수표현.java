package B형대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2이진수표현 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc<= t; tc++) {
            sb.append("#"+ tc+" ");
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Long.parseLong(st.nextToken());
            int num = (1 << N) -1;
            sb.append( (M & num) == num ? "ON\n" : "OFF\n");
        }
        System.out.print(sb);
    }
}