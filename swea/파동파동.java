package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파동파동 {
    static int N, arr[][], power, x, y,pm;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t=  Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            power = Integer.parseInt(st.nextToken()); x = Integer.parseInt(st.nextToken()); y = Integer.parseInt(st.nextToken()); pm = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            makePadong();
        }
    }
    private static void makePadong() {

        //파원
        arr[x][y] = power;

        //상하
        for(int i=1;x-i>0 && x+i < N;i++) {
            try {
                arr[x-i][y] = arr[x-i+1][y]+pm;
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
            try {
                arr[x+i][y] = arr[x+i-1][y]+pm;
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
        }
    }
}
