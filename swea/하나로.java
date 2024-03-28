package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하나로 {

    static int n, parent[];
    static double arr[][], E;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for(int tc = 1; tc<=t; tc++) {
            n = Integer.parseInt(bf.readLine());
            arr = new double[n][n];
            for(int i=0;i<n;i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            E = Double.valueOf(bf.readLine());

            
        }

    }
    
}