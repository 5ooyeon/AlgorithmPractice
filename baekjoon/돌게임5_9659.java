package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임5_9659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(bf.readLine());
        System.out.println(N%2==1?"SK":"CY");
        
    }
}
