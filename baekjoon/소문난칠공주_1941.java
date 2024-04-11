package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class 소문난칠공주_1941 {

    static char[][] arr = new char[5][5];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static HashSet<Integer> set;
    static int ans, startX, startY;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        ans = 0;

        
    }
}
