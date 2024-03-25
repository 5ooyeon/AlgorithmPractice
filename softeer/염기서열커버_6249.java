package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 염기서열커버_6249
 */
public class 염기서열커버_6249 {

    static char dna[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        dna = new char[n][m];

        for(int i=0;i<n;i++) {
            dna[i] = bf.readLine().toCharArray();
        }

        

    }
}