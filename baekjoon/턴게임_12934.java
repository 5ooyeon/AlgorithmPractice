package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 턴게임_12934 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long x = Long.parseLong(st.nextToken()), y = Long.parseLong(st.nextToken());
        long sum = x+y;
        long stnd = (long) Math.sqrt(sum);
        for(long i = stnd+1; i < sum; i++) {
            if(i * (i+1)/2 > sum) {
                System.out.println("-1"); return;
            }
            if(i * (i+1)/2 == sum) {
                System.out.println(i); return;
            }
        }
    }
}
