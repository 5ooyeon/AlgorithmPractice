package baekjoon;

import java.io.*;
import java.util.*;

public class 회장뽑기_2660 {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        arr = new int[t];

        for(int i=0;i<t;i++) {
            arr[i] = i;
        }
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            if(a == -2 && b == -2) break;
            int fa = find(a), fb = find(b);
            if(fa != fb) {
                arr[fa] = fb;
            }
        }
        
    }

    static int find(int a) {
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }
}
