package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 후위표기식_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] input = bf.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<input.length;i++) {

            if(input[i]>=65) { //알파벳
                sb.append(Character.toString(input[i]));
            } else if(input[i] == ')') {
                while(!stack.isEmpty() && stack.peek()!='(') {
                    sb.append(Character.toString(stack.pop()));
                }
                stack.pop();
            } else if(stack.isEmpty() || stack.peek()==40 || input[i]==40) { //stack이 비어있거나 top또는 input이 괄호라면
                stack.add(input[i]);
            } else {
                switch (input[i]) {
                    case 43: case 45: // + - 일때
                        while(!stack.isEmpty() && stack.peek()!= '(') {
                            sb.append(Character.toString(stack.pop()));
                        }
                        stack.push(input[i]);
                        break;
                    case 42 : case 47: // * / 일때
                        while(!stack.isEmpty() && (stack.peek()== '*' || stack.peek()=='/' )) {
                            sb.append(Character.toString(stack.pop()));
                        }
                        stack.push(input[i]);
                        break;
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.append(Character.toString(stack.pop()));
        }
        System.out.println(sb.toString());
    }
}
