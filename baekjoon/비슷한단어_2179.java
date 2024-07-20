package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 비슷한단어_2179
 */
public class 비슷한단어_2179 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        char[][] inputs = new char[N][];

        for(int i=0;i<N;i++) {
            inputs[i] = bf.readLine().toCharArray();
        }

        int idx1 = -1, idx2 = -1, count = -1;

        for(int i=0;i<N-1;i++) {

            for(int j=i+1;j<N;j++) {
                if(inputs[i][0] != inputs[j][0]) continue;
                int cnt = 0;
                while(cnt<inputs[i].length && cnt < inputs[j].length && inputs[i][cnt] == inputs[j][cnt]) {
                    cnt++;
                }
                if(cnt > count) {
                    count = cnt;
                    idx1 = i; idx2 = j;
                }
            }
        }

        for(int i=0;i<inputs[idx1].length;i++) {
            System.out.print(inputs[idx1][i]);
        }
        System.out.println();
        for(int i=0;i<inputs[idx2].length;i++) {
            System.out.print(inputs[idx2][i]);
        }
    }
}