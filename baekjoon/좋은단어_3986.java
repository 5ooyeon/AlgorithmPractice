package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class 좋은단어_3986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Character> stack = new Stack<>();
        int ans = n;
        for(int tc=0;tc<n;tc++) {
            stack.clear();
            char[] input = sc.nextLine().toCharArray();

            for(int i=0;i<input.length;i++) {
                if(stack.isEmpty() || stack.peek()!=input[i]) {
                    stack.add(input[i]);
                } else {
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) {
                ans--;
            }
        }
        System.out.println(ans);
    }
}
