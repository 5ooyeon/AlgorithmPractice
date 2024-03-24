package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈_1629 {

    static int a, b, c, a2;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken()); c =Integer.parseInt(st.nextToken());
        a2 = 1;

        if(b % 2 ==0) {
            a *= a;
            b /= 2;
        } else {
            a2 = a;
            a *= a;
            b /=2;
        }
        
    }
}
