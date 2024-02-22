package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 베르트랑공준_4948 {
    static int cnt = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        while(n!=0) {
            if(n==1) {
                cnt = 1;
            } else if(n==2) {
                cnt = 2;
            } else {
                for(int i= (n+1)%2==0 ? n+2 : n+1; i<=n*2;i+=2) {
                    sosu(i);
                }
            }
            sb.append(cnt+"\n");
            cnt = 0;
            n = Integer.parseInt(bf.readLine());
        }
        System.out.println(sb.toString());
    }
    static void sosu(int num) {
        for(int i=2;i<=(int) Math.sqrt(num);i++) {
            if(num % i ==0) {
                return;
            }
        }
        cnt++;
    }
}
