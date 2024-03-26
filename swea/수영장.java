package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {

    static int price[], month[], ans, lastMonth;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for(int tc =1; tc<=t; tc++) {
            price = new int[4];
            month = new int[12];
            lastMonth = 0;

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0;i<4;i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            ans = price[3];

            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<12;i++) {
                month[i] = Integer.parseInt(st.nextToken());
                if(month[i]!=0) {
                    lastMonth = i;
                }
            }

            for(int i=0;i<12;i++) {
                if(month[i] != 0) {
                    System.out.println("startMonth is"+i);
                    getSum(i, 0);
                    break;
                }
            }
            System.out.println("lastMonth is "+lastMonth);
            sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
    }

    static void getSum(int m, int moneySum) {

        if(m > lastMonth) {
            ans = ans < moneySum ? ans : moneySum;
            return;
        }

        if(moneySum >= ans) {
            return;
        }

        for(int i=m; i<=lastMonth;i++) {
            if(month[i] != 0) {
                //일일권일때
                getSum(i+1, moneySum + month[i]*price[0]);

                //한달일때
                getSum(i+1, moneySum + price[1]);

                //세 달일 때
                getSum(i+3, moneySum + price[2]);

                break;
            }
        }
    }
}
