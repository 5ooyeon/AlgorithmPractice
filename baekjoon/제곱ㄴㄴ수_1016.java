package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class 제곱ㄴㄴ수_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong(), max = sc.nextLong();
        HashSet<Long> set = new HashSet<>();

        long cnt = 0;
        long num = 2;
        for(long i=2; i*i < max; i++) {
            long temp = i * i;
            
        }

        System.out.println(max - min + 1 - cnt);
    }
}
