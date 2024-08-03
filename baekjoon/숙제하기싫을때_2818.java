package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숙제하기싫을때_2818 {
    static int R, C, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        arr = new int[R][C];

        arr[0][0] = 1;
        
        int dir = 1;

        for(int i=0;i<R;i++) {
            for(int jc=0;jc<C;jc++) {
                int j = jc;
                if(jc==0 || jc == C-1) {
                    dir = 2;
                } else if((i+1)%2==1) {
                    dir = 1;
                } else {
                    j = C-1-jc;
                    dir = 3;
                }

                //dir == 1
                //1 -> 4 -> 6 -> 3 반복
                //2 -> 
                
            }
        }
    }
}
