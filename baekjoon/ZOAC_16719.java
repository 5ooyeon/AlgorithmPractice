package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ZOAC_16719 {
    static class Node {
        int idx;
        char letter;

        Node(int idx, char letter) {
            this.idx = idx;
            this.letter = letter;
        }
    }

    public static void main(String[] args) throws IOException {

        char[][] arr;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                if (o1.letter == o2.letter) {
                    return o1.idx - o2.idx;
                }
                return o1.letter - o2.letter;
            }

        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            pq.offer(new Node(i, input.charAt(i)));
        }

        boolean[] visited = new boolean[input.length()];
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.idx])
                continue;

            visited[current.idx] = true;
            sb.append(current.letter);

            // 이전에 선택된 문자들을 포함하여 새로운 결과를 생성
            for (int i = 0; i < input.length(); i++) {
                if (visited[i]) {
                    System.out.print(input.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
