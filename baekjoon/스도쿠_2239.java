package baekjoon;

import java.io.*;
import java.util.*;

public class 스도쿠_2239 {
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++) {
            char[] input = bf.readLine().toCharArray();
            for(int j=0;j<9;j++) {
                arr[i][j] = input[j] - '0';
            }
        }

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(arr[i][j] == 0) dfs(i, j);
            }
        }

    }

    static void dfs(int x, int y) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<9;i++) {
            set.add(i+1);
        }
        //3 * 3
        int startX = x/3 * 3, startY = y/3 * 3;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                set.remove(arr[startX+i][startY+j]);
            }
        }

        //가로세로
        for(int i=0;i<9;i++) {
            set.remove(arr[x][i]);
            set.remove(arr[i][y]);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        

    }
}
