package swea;

import java.io.*;
import java.util.*;

public class 작업순서 {
    static int tc, V, E, arr[];
    static ArrayList<Integer>[] list;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = 0;

        while(++tc <= 4) {
            sb.append("#"+tc+" ");
            StringTokenizer st = new StringTokenizer(bf.readLine());
            V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());

            arr = new int[V];
            list = new ArrayList[V];

            for(int i=0;i<V;i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<E;i++) {
                int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
                list[a].add(b);
                arr[b]++;
            }

            stack = new Stack<>();

            for(int i=0;i<V;i++) {
                if(arr[i] == 0) {
                    stack.push(i);
                }
            }

            while (!stack.isEmpty()) {
                int num = stack.pop();
                sb.append((num+1)+" ");

                for(int n : list[num]) {
                    arr[n]--;

                    if(arr[n] == 0) {
                        stack.push(n);
                    }

                }

            }

            sb.append("\n");

        }
        System.out.println(sb);
    }
}
