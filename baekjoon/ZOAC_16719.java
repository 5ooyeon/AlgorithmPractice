package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ZOAC_16719 {
    static class Node {
        Node left, right;
        char data;
        int idx;

        Node(Node left, Node right, char data, int idx) {
            this.left = left;
            this.right = right;
            this.data = data;
            this.idx = idx;
        }
    }

    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String input = bf.readLine();
        char[] arr = input.toCharArray();
        Arrays.sort(arr);

        // Initialize the head node
        for (int i = 0; i < arr.length; i++) {
            if (input.charAt(i) == arr[0]) {
                head = new Node(null, null, arr[0], i);
                break;
            }
        }

        System.out.println(head.data);

        // Insert remaining characters
        for (int cnt = 1; cnt < arr.length; cnt++) {
            char targetChar = arr[cnt];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == targetChar) {
                    Node targetNode = new Node(null, null, targetChar, i);
                    insertNode(head, targetNode);

                    // Print current state of the tree
                    sb.setLength(0); // Clear the StringBuilder
                    printInOrder(head, sb);
                    System.out.println(sb.toString());

                    break; // Move to the next character to be inserted
                }
            }
        }
    }

    // Insert a node into the tree
    static void insertNode(Node current, Node newNode) {
        while (true) {
            if (newNode.idx < current.idx) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

    // In-order traversal to print the current state of the tree
    static void printInOrder(Node node, StringBuilder sb) {
        if (node != null) {
            printInOrder(node.left, sb);
            sb.append(node.data);
            printInOrder(node.right, sb);
        }
    }
}
