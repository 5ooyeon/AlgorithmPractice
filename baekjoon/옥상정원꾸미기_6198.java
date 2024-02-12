package baekjoon;

import java.io.*;
import java.util.*;

public class 옥상정원꾸미기_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        long cnt =0;
        for(int i=0;i<N;i++) {
            int temp = Integer.parseInt(bf.readLine());

            while(!stack.isEmpty() && stack.peek() <= temp) {
                stack.pop();
            }
            cnt += (long) stack.size();
            stack.push(temp);
        }
        System.out.println(cnt);
    }
}
