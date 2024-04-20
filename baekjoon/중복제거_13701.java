package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class 중복제거_13701 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        BitSet b = new BitSet();
        while(st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if(!b.get(n)) {
                b.set(n);
                sb.append(n+" "); 
            }
        }
        System.out.print(sb);
    }
}
