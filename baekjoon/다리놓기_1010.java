package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 다리놓기_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int tc =0; tc < T; tc++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
            BigInteger mul=BigInteger.valueOf(1), div=BigInteger.valueOf(1);
            while(r!=0) {
                mul = mul.multiply(BigInteger.valueOf(n--));
                div = div.multiply(BigInteger.valueOf(r--));
            }
            sb.append(mul.divide(div)+"\n");
        }
        System.out.println(sb);
    }
}
