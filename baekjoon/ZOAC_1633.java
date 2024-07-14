package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ZOAC_1633 {
    public static void main(String[] args) throws IOException {

        char[][] arr;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        StringBuilder sb = new StringBuilder();

        arr = new char[2][input.length()];
        arr[0] = input.toCharArray();

        List<Character> alphabet = new ArrayList<>();
        for(int i=0;i<input.length();i++) {
            alphabet.add(input.charAt(i));
        }
        
        Collections.sort(alphabet);

        // System.out.println(alphabet.toString());

        String buildWord = "";
        int idx = 0, lastIdx = -1;
        while(buildWord.length() != input.length()) {
            char target = alphabet.get(idx++);
            for(int i=0;i<input.length();i++) {
                if(arr[0][i] == target && arr[1][i] == '')
            }
        }
    }
}
