package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Stack<int[]> stack = new Stack<>();
        int i=0;
        while(st.hasMoreTokens()) {
            int t = Integer.parseInt(st.nextToken());
            if(i==N) {
                break;
            }
            int[] temp = new int[2];
            temp[0] = i++; temp[1] = t;
            if(stack.isEmpty() || stack.peek()[1] >= t) {
                stack.push(temp);
            } else if(stack.peek()[1] < t) {
                while(!stack.isEmpty() && stack.peek()[1] < t) {
                    ans[stack.pop()[0]] = t+1;
                }
                stack.push(temp);
            }
        }
        for(int a : ans) {
            sb.append((a-1)+" ");
        }
        System.out.println(sb.toString());
    }
}
