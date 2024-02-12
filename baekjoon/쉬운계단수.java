package baekjoon;

import java.util.Scanner;

public class 쉬운계단수 {
    static long cnt = 0;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
    }

    static void stairs(int idx) {
        if(idx == N) {
            cnt++; return;
        }
        if(idx == 0) {
            for(int i=1;i<10;i++) {
                
            }
        }
    }
}
