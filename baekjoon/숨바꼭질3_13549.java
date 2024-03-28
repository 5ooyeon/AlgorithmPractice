package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bf.readLine().split(" ");
        int N = Integer.parseInt(t[0]), K = Integer.parseInt(t[1]);

        int time = 0;
        while(N != K) {
            if(N < K) {
                if(K%2==0) {
                    K/=2;
                } else {
                    if(K/2 > N) {
                        time++;
                        K--;
                    } else {
                        time++;
                        K++;
                    }
                }
            } else {
                time++;
                K++;
            }
        }
        System.out.println(time);
    }
}
