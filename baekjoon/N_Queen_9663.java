package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N_Queen_9663 {
    static int ans, n, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        ans = 0;
        nQueen(0);
        bw.write(Integer.toString(ans));
        bw.flush();
    }

    static void nQueen(int i) {
        if (i==n) {
            ans++; return;
        }
        for (int j = 0; j < n; j++) {
            arr[i] = j;
            if (!checkMate(i)) { 
                nQueen(i + 1);
            }
        }
    }

    static Boolean checkMate(int i) {
        for (int j=0;j<i;j++) {
            if (arr[i]==arr[j] || i-j ==Math.abs(arr[i]-arr[j])) {
                return true;
            }
        }
        return false;
    }

}
