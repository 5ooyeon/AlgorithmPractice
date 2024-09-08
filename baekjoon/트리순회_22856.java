package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회_22856 {
    static class Node {
        int data;
        int left, right;

        Node(int data, int left, int right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node head, tree[];
    static long ans, cnt, N, endPoint;
    static boolean visited[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = (long) Integer.parseInt(bf.readLine());

        tree = new Node[(int) N];
        visited= new boolean[(int) N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int data = Integer.parseInt(st.nextToken())-1,
            a = Integer.parseInt(st.nextToken())-1,
            b = Integer.parseInt(st.nextToken())-1;

            Node node = new Node(data, a, b);
            tree[data] = node;

        }
        endPoint = -1;
        int idx = 0;
        while(endPoint == -1) {
            if(tree[idx].right != -2) {
                idx = tree[idx].right;
            } else {
                endPoint = idx;
            }
        }
        

        ans = 0L; cnt = 0L;

        ansOrder(0);

    }
    private static void ansOrder(int i) {
        if(!visited[i]) {
            visited[i] = true;
            cnt++;
        }

        ans++;

        if(cnt == N && i == endPoint) {
            System.out.println(ans-1); System.exit(0);
        }
        Node node = tree[i];
        if(node.left>=0) {
            ansOrder(node.left);
            ans++;
        }
        if(node.right>=0) {
            ansOrder(node.right);
            ans++;
        }
        if(cnt == N && i == endPoint) {
            System.out.println(ans-1); System.exit(0);
        }
    }

}
