package swea;

import java.util.Scanner;

public class 퍼펙트셔플2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.parseInt(sc.nextLine());
        for(int tc=1;tc<=n;tc++) {
            int l = (Integer.parseInt(sc.nextLine())+1)/2;
            String[] t = sc.nextLine().split(" ");
            System.out.print("#"+tc);
            for(int i=0;i<l;i++) {
                System.out.print(" "+t[i]);
                if(t.length>i+l) System.out.print(" "+t[i+l]);
            }
            System.out.println();
        }
    }
}
