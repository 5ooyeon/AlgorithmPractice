package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class 이진검색트리_5639 {
    static class Node{
        int data;
        Node child1, child2;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node child1, Node child2) {
            this.data = data;
            this.child1 = child1;
            this.child2 = child2;
        }

    }
    static LinkedList<Node> list = new LinkedList<>();
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            int data;
            try {
                data = Integer.parseInt(bf.readLine());
            } catch (IOException e) {
                System.out.print(sb);
                return;
            }
            Node node = new Node(data);
            if(list.isEmpty()) {
                list.add(node); continue;
            }
            Node preNode = list.getLast();
            if(preNode.data > node.data) {
                preNode.child1 = node; continue;
            }
        }
    }
}
