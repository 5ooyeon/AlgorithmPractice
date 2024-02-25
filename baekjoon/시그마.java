package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 시그마 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] a = new long[2];
        a[0] = sc.nextLong(); a[1]= sc.nextLong();
        Arrays.sort(a);
        
        long ans = 0;
        while(a[0]<a[1]) {
            ans += (a[0]++ + a[1]--);
        }
        System.out.println(ans);
    }
}
