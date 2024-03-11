package swea;

import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String t = sc.nextLine();
        int ans = 0;
        for(int i=0;i<t.length();i++) {
            if(t.charAt(i)=='a' ||t.charAt(i)=='e' ||t.charAt(i)=='i' ||t.charAt(i)=='o' ||t.charAt(i)=='u') {
                ans++;
            }
        }
        System.out.println(ans);
    }
}