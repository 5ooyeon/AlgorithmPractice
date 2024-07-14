package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * INK_30036
 */
public class INK_30036 {
    static int I, N, K;
    static char inkList[], arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        I = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        inkList = bf.readLine().toCharArray();
        arr = new char[N][N];
        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
        }
    }
}