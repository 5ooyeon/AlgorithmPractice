package baekjoon;

import java.util.Scanner;

public class Z_1074 {
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), r = sc.nextInt(), c = sc.nextInt();
        ans = 0;
        divide((int) Math.pow(2, N), r, c, 0);
        System.out.println(ans);
    }
    static void divide(int size, int x, int y, int startNum) {
        if(size==1) {
            ans = startNum;
            return;
        }
        size /=2;
        if(x < size) { //1,2 사분면
            if(y < size) { //1 사분면
                divide(size, x, y, startNum);
            } else { //2 사분면
                divide(size, x, y-size, (int) (startNum + Math.pow(size, 2)));
            }
        } else { //3, 4 사분면
            if(y < size) {
                divide(size, x-size, y, (int) (startNum + Math.pow(size, 2) * 2));
            } else {
                divide(size, x-size, y-size, (int) (startNum + Math.pow(size, 2) * 3));
            }
        }
    }
}
