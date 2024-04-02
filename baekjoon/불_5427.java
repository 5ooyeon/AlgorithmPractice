package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 불_5427 {
    static int n,m;
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int tc= 0;tc <t;tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
            arr = new char[n][m];
            for(int i=0;i<n;i++) {
                arr[i] = bf.readLine().toCharArray();
            }
        }
    }
}
