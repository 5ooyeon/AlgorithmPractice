package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기지국 {
    static int N;
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc<=t ; tc++) {
            N = Integer.parseInt(bf.readLine());
            arr = new char[N][N];
            for(int i=0;i<N;i++) {
                arr[i] = bf.readLine().toCharArray();
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(arr[i][j] < 68) {
                        killhouse(i, j);
                    }
                }
            }
            int ans = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(arr[i][j] == 'H') {
                        ans++;
                    }
                }
            }
            sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb.toString());
    }
    private static void killhouse(int x, int y) {
        int length = arr[x][y] - 64;

        //상
        try {
            for(int i=1;i<=length;i++) {
                if(arr[x-i][y] == 'H') {
                    arr[x-i][y] = 'X';
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
        }

        //하
        try {
            for(int i=1;i<=length;i++) {
                if(arr[x+i][y] == 'H') {
                    arr[x+i][y] = 'X';
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
        }

        //좌
        try {
            for(int i=1;i<=length;i++) {
                if(arr[x][y-i] == 'H') {
                    arr[x][y-i] = 'X';
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
        }

        //우
        try {
            for(int i=1;i<=length;i++) {
                if(arr[x][y+i] == 'H') {
                    arr[x][y+i] = 'X';
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
        }
    }
}
