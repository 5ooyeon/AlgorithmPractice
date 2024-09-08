package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 스택2_28278 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order == 1) {
                deque.offer(Integer.parseInt(st.nextToken()));
            } else if(order == 2) {
                if(deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.pollLast()+"\n");
                }
            } else if(order == 3) {
                sb.append(deque.size()+"\n");
            } else if(order == 4) {
                sb.append(deque.isEmpty() ? "1\n" : "0\n");
            } else {
                if(deque.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(deque.peekLast()+"\n");
                }
            }
        }
        System.out.print(sb);
    }
}
