package baekjoon;

import java.util.Scanner;

public class UDPC파티_27919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int uc =0;
        int dp =0;
        for(int i=0;i<arr.length;i++) {
            switch(arr[i]) {
                case 'U':case 'C':
                    uc++; break;
                case 'D':case'P':
                    dp++; break;
                default:
                    break;
            }
        }
        if(uc <= (dp+1)/2) {
            System.out.println("DP");
        } else if(dp == 0) {
            System.out.println("U");
        } else {
            System.out.println("UDP");
        }
    }
}
