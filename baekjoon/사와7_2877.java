package baekjoon;

import java.io.*;

public class 사와7_2877 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine())+1;
        StringBuilder sb = new StringBuilder();
        String aa = Long.toBinaryString(N);
        for(int i=1;i<aa.length();i++) {
            sb.append(aa.charAt(i)=='1' ? "7" : "4");
        }
        System.out.println(sb);
    }

}
