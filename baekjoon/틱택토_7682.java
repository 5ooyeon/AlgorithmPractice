package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 틱택토_7682 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char input[], tictactoe[][];
        while(true) {
            input = bf.readLine().toCharArray();
            if(input[0] == 'e') {
                System.out.print(sb); return;
            }
            tictactoe = new char[3][3];
            int t = 0, x = 0, y = 0;
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    tictactoe[i][j] = input[t++];
                    if(tictactoe[i][j] == 'X') {
                        x++;
                    } else if(tictactoe[i][j] == 'O') {
                        y++;
                    }
                }
            }

            if(y > x) {
                sb.append("invalid\n"); continue;
            }

            

        }
    }
}
