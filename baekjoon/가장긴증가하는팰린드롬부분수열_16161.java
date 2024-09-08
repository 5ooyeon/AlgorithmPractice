package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는팰린드롬부분수열_16161 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int S_length = Integer.parseInt(bf.readLine());

        int[] arr = new int[S_length];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<S_length;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
    }
}
