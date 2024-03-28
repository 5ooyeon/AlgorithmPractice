package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 최소신장트리 {

    static class Node{
        int e1, e2, value;

        Node(int e1, int e2, int value) {
            this.e1 = e1;
            this.e2 = e2;
            this.value = value;
        }
    }

    static TreeSet<Node> set = new TreeSet<>(new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            if(o1.value == o2.value) {
                return -1;
            }
            return o1.value - o2.value;
        }
        
    });

    static int n, m, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        for(int tc = 1; tc <= t ; tc++) {
            sb.append("#"+tc+" ");
            set.clear();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken())+1; m = Integer.parseInt(st.nextToken());

            arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = i;
            }

            for(int i=0;i<m;i++) {
                st = new StringTokenizer(bf.readLine());
                set.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            int cnt = 0, valueSum = 0;
            while(cnt != n-1) {
                Node n = set.pollFirst();
                int a = find(n.e1), b = find(n.e2);
                if(a != b) {
                    arr[a] = b;
                    cnt++; valueSum += n.value;
                }
            }
            sb.append(valueSum+"\n");
        }
        System.out.println(sb);

    }

    static int find(int e) {
        if(arr[e] == e) {
            return e;
        }
        return arr[e] = find(arr[e]);
    }
}
