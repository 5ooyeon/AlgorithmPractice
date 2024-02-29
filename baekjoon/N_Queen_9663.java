package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class N_Queen_9663 {
    static int arr[][], n, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <=t ;tc++) {
            n = Integer.parseInt(bf.readLine());
            arr = new int[n][n];
            ans = 0;
            NQueen(0, 0, 0);
            sb.append("#"+tc+" "+ans+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void NQueen(int cnt, int x, int y) {
        if(cnt==n) {
            ans ++;
            return;
        }

        for(int i=x;i<n;i++) {
            for(int j=i==x ? y : 0;j<n;j++) {
                if(arr[i][j] ==0) {
                    HashSet<int[]> set = putQueen(i, j);
                    NQueen(cnt+1, i+1, j);
                    Iterator itr = set.iterator();
                    while(itr.hasNext()) {
                        int[] temp = (int[]) itr.next();
                        arr[temp[0]][temp[1]] = 0;
                    }
                }
            }
        }
    }

    private static HashSet<int[]> putQueen(int x, int y) {
        HashSet<int[]> set = new HashSet<>();
        int[][] returnNum = new int[n][n];
        for(int i=0;i<n;i++) {
            if(arr[i][y] == 0) {
                arr[i][y] = 1;
                int[]temp = new int[2];
                temp[0] = i; temp[1] = y;
                set.add(temp);
            }
            if(arr[x][i] == 0) {
                arr[x][i] = 1;
                int[]temp = new int[2];
                temp[0] = x; temp[1] = i;
                set.add(temp);
            }
        }
        for(int i=1;i<=n;i++) {
            try {
                if(arr[x-i][y-i] == 0) {
                    arr[x-i][y-i] = 1;
                    int[]temp = new int[2];
                    temp[0] = x-i; temp[1] = y-i;
                    set.add(temp);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
            try {
                if(arr[x-i][y+i] == 0) {
                    arr[x-i][y+i] = 1;
                    int[]temp = new int[2];
                    temp[0] = x-i; temp[1] = y+i;
                    set.add(temp);
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
            try {
                if(arr[x+i][y-i] == 0) {
                    arr[x+i][y-i] = 1;
                    int[]temp = new int[2];
                    temp[0] = x+i; temp[1] = y-i;
                    set.add(temp);
                }
 
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
            try {
                if(arr[x+i][y+i] == 0) {
                    arr[x+i][y+i] = 1;
                    int[]temp = new int[2];
                    temp[0] = x+i; temp[1] = y+i;
                    set.add(temp);
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
        }

        return set;

    }
}
