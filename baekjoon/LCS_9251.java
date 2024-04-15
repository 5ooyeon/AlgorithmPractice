package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] a = bf.readLine().toCharArray(), b = bf.readLine().toCharArray(); int[][] arr = new int[a.length+1][b.length+1];

        for(int i=0;i<a.length;i++) {
            for(int j=0;j<b.length;j++) {
                if(a[i] == b[j]) {
                    arr[i+1][j+1] = arr[i][j] + 1;
                } else {
                    arr[i+1][j+1] = Math.max(arr[i][j+1], arr[i+1][j]);
                }
            }
        }
        System.out.println(arr[a.length][b.length]);
    }
}
