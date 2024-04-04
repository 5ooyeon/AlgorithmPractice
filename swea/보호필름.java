package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보호필름 {
    static int D, W, K, film[][], cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc<=T; tc++) {
            sb.append("#"+tc+" ");
            StringTokenizer st = new StringTokenizer(bf.readLine());
            D = Integer.parseInt(st.nextToken()); W = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
            film = new int[D][W];
            for(int i=0;i<D;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<W;j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            cnt = 0;
            
            

        }
    }
}
