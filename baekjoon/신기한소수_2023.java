package baekjoon;

import java.util.Scanner;

public class 신기한소수_2023 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static String input = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        printPrime(2, 0); printPrime(3, 0); printPrime(5, 0); printPrime(7, 0);
        System.out.println(sb.toString());
        
    }
    private static void printPrime(int num, int cnt) {

        for(int i=2;i<num;i++) {
            if(num % i ==0) {
                return;
            }
        }
        if(cnt==N-1) {
            sb.append(num+"\n");
            return;
        }
        for(int i=1;i<=9;i++) {
            input = Integer.toString(num);
            input += Integer.toString(i);
            printPrime(Integer.parseInt(input), cnt+1);
        }
    }
}
