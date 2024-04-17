package baekjoon;

import java.io.*;
import java.util.*;

public class 은하철도_17250 {
    static int arr[], parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        arr = new int[N]; parent = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            parent[i] = i;
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            int fa = find(a), fb = find(b);
            
            if(fa==fb) {
                bw.write(Integer.toString(arr[fa])+"\n");
            } else if(fa < fb) {
                parent[fb] = fa;
                arr[fa] += arr[fb];
                arr[fb] = 0;
                bw.write(Integer.toString(arr[fa])+"\n");
            } else {
                parent[fa] = fb;
                arr[fb] += arr[fa];
                arr[fa] = 0;
                bw.write(Integer.toString(arr[fb])+"\n");
            }
        }
        bw.flush();
    }
    static int find(int a) {
        if(a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
