package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 최소스패닝트리_1197 {

    static class Node{
        int A;
        int B;
        int V;

        Node(int A, int B, int V) {
            this.A = A;
            this.B = B;
            this.V = V;
        }
    }

    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

        TreeSet<Node> info = new TreeSet<>(new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                if(o1.V == o2.V) {
                    return -1;
                }
                return o1.V - o2.V;
            }
            
        });

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(bf.readLine());
            info.add(new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()))) ;
        }

        arr = new int[V];
        for(int i=0;i<V;i++) {
            arr[i] = i;
        }

        int cnt = 0, valueSum = 0;
        while(cnt != V-1) {
            Node n = info.pollFirst();
            int a = find(n.A), b = find(n.B);
            if(a != b) {
                cnt++; valueSum += n.V;
                arr[a] = b;
            }
        }
        System.out.println(valueSum);

    }

    static int find(int a) {
        if(a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}
