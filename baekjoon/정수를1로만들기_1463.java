package baekjoon;

import java.util.Scanner;

public class 정수를1로만들기_1463 {
    static int[] mm;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        mm = new int[N+1];
        for(int i=2;i<=N;i++) {
            mm[i] = mm[i-1] + 1;
            if(i%2==0) {
                mm[i] = Math.min(mm[i], mm[i/2]+1);
            }
            if(i%3==0) {
                mm[i] = Math.min(mm[i], mm[i/3]+1);
            }
        }
        System.out.println(mm[N]);;
    }
}
