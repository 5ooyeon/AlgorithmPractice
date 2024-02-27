package swea;

import java.util.Scanner;

public class 이진수표현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++) {
            System.out.print("#"+tc+" ");
            int m = sc.nextInt(), n = sc.nextInt();
            if(n%Math.pow(2, m)==Math.pow(2, m)-1) {
                System.out.println("ON");
            } else {
                System.out.println("OFF");
            }
        }
    }
}
