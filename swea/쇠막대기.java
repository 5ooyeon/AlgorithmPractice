package swea;

import java.io.*;
import java.util.*;
 
public class 쇠막대기 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int ans = 0;
        int temp = 0;
            
        for(int i=0;i<input.length();i++) {
            if(input.charAt(i)=='(') {
                temp++;
            } else { //input.charAt(i) == ')'일 경우
                if(input.charAt(i-1)=='(') { //레이저일경우
                    ans += --temp;
                } else { //막대 끝일 경우
                    temp--;
                    ans++;
                }
            }
        }
       System.out.println(ans);
    }
}