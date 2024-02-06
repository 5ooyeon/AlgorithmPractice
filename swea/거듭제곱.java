package swea;

import java.util.Scanner;

public class 거듭제곱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<10;i++) {
            System.out.println("#"+ sc.nextInt()+" "+multiple(sc.nextInt(), sc.nextInt()));
        }
    }
    static int multiple(int m, int cnt) {
        if(cnt == 1) {
            return m;
        }
        return m * multiple(m,--cnt);
    }
}
