package swea;

import java.util.Scanner;

public class 준홍이의카드놀이2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        for(int tc = 1;tc <=N;tc++) {
            int n = sc.nextInt(), m = sc.nextInt();
            System.out.print("#"+tc);
            int temp = Math.min(n, m);
            for(int i=0;i<=Math.abs(n-m);i++) {
                System.out.print(" "+ ++temp);
            }
            System.out.println();
        }
    }
}
