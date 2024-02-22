package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class b8진수2진수_1212 {
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<String> output = new ArrayList<>();
        String temp = get2(input.charAt(0));
        while(temp.charAt(0)=='0') {
            temp = temp.substring(1,temp.length());
        }
        output.add(temp);
        for(int i=1;i<input.length();i++) {
            output.add(get2(input.charAt(i)));
        }
        for(String a : output) {
            System.out.print(a);
        }
    }
    static String get2(char i) {
        switch (i) {
            case '0':
                return "000";
            case '1':
                return "001";
            case '2':
                return "010";
            case '3': return "011";
            case '4': return "100";
            case '5': return "101";
            case '6': return "110";
            case '7': return "111";
            default:
            return "";
        }
    }
}
