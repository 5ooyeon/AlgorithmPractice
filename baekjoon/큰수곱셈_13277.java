package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 큰수곱셈_13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] a1  = bf.readLine().split(" ");
        BigInteger a =  new BigInteger(a1[0]), b = new BigInteger(a1[1]);
        System.out.println(a.multiply(b));
    }
}
