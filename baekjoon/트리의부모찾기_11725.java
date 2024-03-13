package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
    static ArrayList<Integer>[] arr;
    static int num, node[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(bf.readLine());
        arr = new ArrayList[num];
        node = new int[num];
        for(int i=0;i<num;i++) {
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=1;i<num;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            arr[a].add(b); arr[b].add(a);
        }
        node[0] = -1;
        findParant(0);
        for(int i=1;i<num;i++) {
            sb.append(node[i]+"\n");
        }
        System.out.println(sb.toString());
    }
    private static void findParant(int n) {
        for(int i : arr[n]) {
            if(node[i] == 0) {
                node[i] = n+1;
                findParant(i);
            }
        }
    }
}