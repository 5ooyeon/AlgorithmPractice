package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 리모컨_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        HashSet<Character> set = new HashSet<>();
        if(n!=0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0;i<n;i++) {
                set.add(st.nextToken().charAt(0));
            }
        }

        int ans = Math.abs(N - 100);

        String temp = "";
        int i= 0;
        Boolean canTab = false;
        while(canTab == false) {
            temp = Integer.toString(N-i);
            canTab = true;
            for(int idx =0; idx < temp.length();idx++) {
                if(set.contains(temp.charAt(idx))) {
                    canTab = false; break;
                }
            }
            i++;
        }
        int ans2 = temp.length() + N - Integer.parseInt(temp);
        ans = ans > ans2 ? ans2 : ans;

        i= 1;
        canTab = false;
        while(canTab == false && i <=500000) {
            temp = Integer.toString(N+i);
            canTab = true;
            for(int idx =0; idx < temp.length();idx++) {
                if(set.contains(temp.charAt(idx))) {
                    canTab = false; break;
                }
            }
            i++;
        }
        ans2 = temp.length() + Integer.parseInt(temp) - N;
        ans = ans > ans2 ? ans2 : ans;
        System.out.println(ans);
    }
}
