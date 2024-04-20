package B형대비.No1새로운불면증치료법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        testcase : for(int tc = 1;tc<=t;tc++) {
            sb.append("#"+tc+" ");
            int N = Integer.parseInt(bf.readLine());
            int b10 = (1 << 10) - 1;
            int have = 0;
            int ans = 0;
            while((have & b10) != b10) {
                ans++;
                int num = N * ans;
                int ten = 10;
                while(num > 0) {
                    have |= 1 << (num % ten);
                    num /= ten;
                }
            }
            sb.append(N*ans+"\n");
        }
        System.out.print(sb);
    }
}
