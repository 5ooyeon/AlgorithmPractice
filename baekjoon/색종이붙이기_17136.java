package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기_17136 {
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0;i<10;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<10;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
