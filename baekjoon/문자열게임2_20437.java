package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열게임2_20437 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++) {
            String word = bf.readLine();
            int K = Integer.parseInt(bf.readLine()); 
 
            if(K == 1) {
                System.out.println("1 1");
                continue;
            }
 
            int[] alpha = new int[26];
            for(int j = 0; j < word.length(); j++) {
                alpha[word.charAt(j) - 'a']++;
            }
 
            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int j = 0; j < word.length(); j++) {
                if(alpha[word.charAt(j) - 'a'] < K) continue;
 
                int count = 1;
                for(int l = j + 1; l < word.length(); l++) {
                    if(word.charAt(j) == word.charAt(l)) count++;
                    if(count == K) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);
        }
    }        
}
