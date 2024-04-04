package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열폭발_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String bomb = bf.readLine();
        while(input.contains(bomb)) {
            StringTokenizer st = new StringTokenizer(input, bomb);
            input = "";
            while(st.hasMoreTokens()) {
                input += st.nextToken();
            }
        }
        System.out.println(input== "" ? "FRULA" : input);
    }
}
