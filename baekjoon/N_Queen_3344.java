package baekjoon;

import java.util.Scanner;

public class N_Queen_3344 {
    static int n, arr[], check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        check = 1;
        nQueen(0);
        System.out.println(sb.toString());
    }
    private static void nQueen(int i) {
        if(check==0) {
            return;
        }
        if (i==n) {
            for(int idx=0;idx<n;idx++) {
                sb.append(arr[idx]+"\n");
            }
            check = 0;
            return;
        }
        for (int j = 0; j < n; j++) {
            arr[i] = j;
            if (!checkMate(i)) { 
                nQueen(i + 1);
            }
        }
    }
    private static boolean checkMate(int i) {
        for (int j=0;j<i;j++) {
            if (arr[i]==arr[j] || i-j ==Math.abs(arr[i]-arr[j])) {
                return true;
            }
        }
        return false;
    }
}
