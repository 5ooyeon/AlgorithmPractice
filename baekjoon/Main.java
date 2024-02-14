package baekjoon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String func = bf.readLine();
            int size = Integer.parseInt(bf.readLine());
            boolean isReversed = false, isError = false;
            Deque<String> deque = new LinkedList<>();

            String input = bf.readLine();
            input = input.substring(1, input.length() - 1);
            StringTokenizer st = new StringTokenizer(input, ",");

            for (int i = 0; i < size; i++) {
                deque.offer(st.nextToken());
            }

            int cnt = (int) func.chars().filter(ch -> ch == 'D').count();

            if (cnt > size) {
                sb.append("error\n");
                continue;
            }

            for (int i = 0; i < func.length(); i++) {
                if (func.charAt(i) == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        deque.clear();
                        break;
                    } else {
                        if (isReversed) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                        size--;
                    }
                }
            }

            if (!isError) {
                sb.append("[");
                StringJoiner sj = new StringJoiner(",");
                
                for (int i = 0; i < size; i++) {
                    sj.add(isReversed ? deque.pollLast() : deque.pollFirst());
                }

                sb.append(sj.toString()).append("]\n");
            }
        }

        System.out.println(sb.toString());
    }
}
