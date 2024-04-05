package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {
    static int n, arr[], dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        dp = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        System.out.println(upStairs(n-1));
    }

    static int upStairs(int idx) {
        if (idx < 0)
            return 0; // 범위를 벗어나면 0 반환
        if (idx == 0)
            return arr[0]; // 첫 번째 계단일 경우 그대로 반환
        if (idx == 1)
            return arr[0] + arr[1]; // 두 번째 계단일 경우 첫 번째 계단과 두 번째 계단을 밟는 것이 최대

        if (dp[idx] != 0)
            return dp[idx];

        // idx번째 계단을 밟을 경우와 밟지 않을 경우 중 최대값을 선택
        return dp[idx] = Math.max(upStairs(idx - 2), upStairs(idx - 3) + arr[idx - 1]) + arr[idx];
    }
        
    // }
    // public static void main(String[] args) throws IOException {
    //     BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    //     n = Integer.parseInt(bf.readLine());
    //     arr = new int[n+1];
    //     dp = new int[n+1];

    //     for(int i=0;i<n;i++) {
    //         arr[i+1] = Integer.parseInt(bf.readLine());
    //     }

    //     System.out.println(upStairs(n, 0));
    // }

    // static int upStairs(int idx, int cnt) {

        

    //     if(idx < 1) {
    //         return arr[0];
    //     }

    //     if(cnt == 1) {
    //         return arr[idx] + upStairs(idx-2, 0);
    //     }

    //     return Math.max(arr[idx]+upStairs(idx-2, 0), arr[idx]+upStairs(idx-1, cnt+1));
        
    // }
}
