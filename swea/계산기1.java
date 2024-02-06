package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class 계산기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();

        for(int tc=1;tc<=10;tc++) {
            int n = Integer.parseInt(bf.readLine());
            char[] input = bf.readLine().toCharArray();
            List<Character> output = new ArrayList<>();
            int idx = 0;
            for(int i=0;i<n;i++) {
                if(input[i]>=48) { //피연산자라면
                    output.add(input[i]);
                } else if(stack.isEmpty() || stack.peek()==40 || input[i]==40) { //stack이 비어있거나 top또는 input 괄호라면
                    stack.add(input[i]);
                } else if(input[i]==42) { // * 이라면
                    while(!stack.empty() && stack.peek()==42) { //*이 사라질때까지 제거
                        output.add(stack.pop());
                    }
                    stack.add(input[i]);
                } else if(input[i]==43) { //+라면
                    while(!stack.empty() && stack.peek()!=40) {
                        output.add(stack.pop());
                    }
                    stack.add(input[i]);
                } else { //)라면
                    while(!stack.empty() && stack.peek()!=40) {
                        output.add(stack.pop());
                    }
                    stack.pop();
                }
            }
            while(!stack.empty()) {
                output.add(stack.pop());
            }

            for(char a: output) {
                System.out.print(a);
            }


            for(int i=0;i<output.size();i++) {
                if(output.get(i)>=48) {
                    outputStack.add(output.get(i)-'0');
                } else {
                    int b = outputStack.pop(), a =outputStack.pop();
                    if(output.get(i)==42) {
                        a*=b;
                    } else {
                        a+=b;
                    }
                    outputStack.add(a);
                }
            }
            // System.out.println(outputStack.pop());

        }
    }
}
