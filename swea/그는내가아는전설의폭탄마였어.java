package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그는내가아는전설의폭탄마였어
 */
public class 그는내가아는전설의폭탄마였어 {
    static int N, poktan, arr[][], ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= t ; tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); poktan = Integer.parseInt(st.nextToken());
            ans = 0;
            arr = new int[N][N];
            for(int i=0;i<N;i++) {
                st= new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    plus(i, j);
                    x(i, j);
                }
            }

            sb.append("#"+tc+" "+ans+"\n");

        }
        System.out.println(sb.toString());
    }
    private static void x(int x, int y) {

        int returnNum = arr[x][y];

        //좌상
        try {
            for(int i=1;i<=poktan;i++) {
                returnNum += arr[x-i][y-i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        //좌하
        try {
            for(int i=1;i<=poktan;i++) {
                returnNum += arr[x+i][y-i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        //우상
        try {
            for(int i=1;i<=poktan;i++) {
                returnNum += arr[x-i][y+i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        //우하
        try {
            for(int i=1;i<=poktan;i++) {
                returnNum += arr[x+i][y+i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        ans = ans > returnNum ? ans : returnNum;
    }
    private static void plus(int x, int y) {
        int returnNum = arr[x][y];

        //상
        try {
            for(int i=1;i<=poktan;i++) {
                returnNum += arr[x+i][y];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        //하
        try {
            for(int i=1;i<=poktan;i++) {
                returnNum += arr[x-i][y];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        //좌
        try {
            for(int i=1;i<=poktan;i++) {
                returnNum += arr[x][y-i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        //우
        try {
            for(int i=1;i<=poktan;i++) {
                returnNum += arr[x][y+i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        ans = ans > returnNum ? ans : returnNum;
    }
}