package baekjoon;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class 문자열폭발_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = bf.readLine().toCharArray(); String bomb = bf.readLine();

        for(int i=0;i<input.length;i++) {
            sb.append(input[i]);
            if(sb.length() >= bomb.length() && sb.substring(sb.length()-bomb.length()).equals(bomb)) {
                sb.delete(sb.length()-bomb.length(), sb.length());
            }
        }
        System.out.print(sb.length()==0 ? "FRULA" : sb);
    }
}