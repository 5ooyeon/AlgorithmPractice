package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class 스택수열_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(bf.readLine());

        Stack<Integer> stack = new Stack<>();
        int point = 1; int check = 0;
        for(int i=1;i<=N;i++) {
            int a = Integer.parseInt(bf.readLine());
            while(point <= a) {
                stack.push(point++);
                sb.append("+\n");
            }
            if(stack.peek()==a) {
                stack.pop();
                sb.append("-\n");
            } else {
                check = -1;
            }
        }
        if(check == -1) {
            System.out.println("NO");
        } else {
            System.out.println(sb.toString());
        }
    }
}