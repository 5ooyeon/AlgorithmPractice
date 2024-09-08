package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수업시간에교수님몰래교실을나간상근이_2825 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Map<Integer, Integer> nums = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String temp = bf.readLine();
            int number = 0;
            for(int j = 0; j < temp.length(); j++) {
                number |= 1 << (temp.charAt(j) - '0');
            }
            nums.put(number, nums.getOrDefault(number, 0) + 1);
        }

        long ans = 0;
        for (Map.Entry<Integer, Integer> entry:nums.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            
            ans += (long)cnt*(cnt-1)/2;
            
            for (int num2 : nums.keySet()) {
                if(num >= num2) continue;
                if((num & num2) != 0) {
                    ans += (long) cnt*nums.get(num2);
                }
            }
        }
        System.out.println(ans);
    }
}