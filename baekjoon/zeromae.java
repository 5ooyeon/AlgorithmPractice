package baekjoon;

import java.util.Scanner;

public class zeromae {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        if(a.charAt(0)==a.charAt(1)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
