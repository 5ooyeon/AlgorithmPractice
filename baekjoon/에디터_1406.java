package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 에디터_1406 {
    static Stack<String> left = new Stack<>();
    static Stack<String> right = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] temp = bf.readLine().toCharArray();

        for(int i=0; i<temp.length;i++) {
            left.push(Character.toString(temp[i]));
        }
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            switch (st.nextToken()) {
                case "L":
                    if(!left.isEmpty()) {
                        right.add(left.pop());
                    }
                    break;
                case "D":
                    if(!right.isEmpty()) {
                        left.add(right.pop());
                    }
                    break;
                case "B":
                    if(!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                default:
                    left.add(st.nextToken());
                    break;
            }
        }
        println();
    }

    static void println() {
        StringBuilder sb = new StringBuilder();
        for(String a : left) {
            sb.append(a);
        }
        for(int i=0;i<right.size();i++) {
            sb.append(right.get(right.size()-1-i));
        }
        System.out.print(sb.toString());
    }
}
