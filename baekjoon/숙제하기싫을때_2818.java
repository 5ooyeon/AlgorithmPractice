package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숙제하기싫을때_2818 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int R = Integer.parseInt(input[0]), C = Integer.parseInt(input[1]);

        int up = 1, down = 6, left = 4, right = 3, front = 2, back = 5;
        int totalSum = up;

        for(int i=0;i<R;i++) {
            for(int jc=0;jc<C;jc++) {
                
                //아래로 내리기
                if(jc == C-1) {
                    if(i==R-1) {
                        System.out.println(totalSum); return;
                    }
                    int temp = down;
                    down = front;
                    front = up;
                    up = back;
                    back = temp;
        
                    totalSum += up;
                } else if((i+1)%2 == 1) {
                    // 주사위를 오른쪽으로 굴릴 때
                    int temp = up;
                    up = left;
                    left = down;
                    down = right;
                    right = temp;

                    totalSum += up;
                } else if((i+1)%2 == 0) {
                    // 주사위를 왼쪽으로 굴릴 때
                    int temp = up;
                    up = right;
                    right = down;
                    down = left;
                    left = temp;

                    totalSum += up;
                }
            }
        }

    }
}
