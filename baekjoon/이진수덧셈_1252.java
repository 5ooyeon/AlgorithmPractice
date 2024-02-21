package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 이진수덧셈_1252
 */
public class 이진수덧셈_1252 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");

        String num1 = "";
        for (int i = num[0].length() - 1; i >= 0; i--) {
            num1 += Character.toString(num[0].charAt(i));
        }
        String num2 = "";
        for (int i = num[1].length() - 1; i >= 0; i--) {
            num2 += Character.toString(num[1].charAt(i));
        }
        String ans = "";
        int plusNum = 0;
        int idx = 0;
        while (idx < num1.length() || idx < num2.length()) {
            int numInt1 = 0;
            if (idx < num1.length()) {
                numInt1 = num1.charAt(idx) - '0';
            }
            int numInt2 = 0;
            if (idx < num2.length()) {
                numInt2 = num2.charAt(idx) - '0';
            }
            int hap = numInt1 + numInt2 + plusNum;
            plusNum = 0;
            if (hap > 1) {
                hap -= 2;
                plusNum = 1;
            }
            ans += Integer.toString(hap);
            idx++;
        }
        if (plusNum != 0) {
            ans += "1";
        }

        ArrayList<Character> arr = new ArrayList<>();
        for(int i=ans.length()-1;i>=0;i--) {
            arr.add(ans.charAt(i));
        }
        while(arr.get(0) == '0' && arr.size()!= 0) {
            arr.remove(0);
        }
        for(char a : arr) {
            System.out.print(a);
        }
    }
}