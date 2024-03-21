package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MilkFactory_17199 {
    static int N;
    static HashSet<Integer>[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        set = new HashSet[N];
        for(int i=0;i<N;i++) {
            set[i] = new HashSet<>();
        }
        for(int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            set[b-1].add(a-1);
        }
        if(N==1) {
            System.out.println(-1);System.exit(0);
        }
        for(int i=0;i<N;i++) {
            if(set[i].size()==N-1) {
                System.out.println(i+1);System.exit(0);
            }
        }
        System.out.println(-1);
    }
}
