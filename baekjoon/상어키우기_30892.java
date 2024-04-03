package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 상어키우기_30892 {
    static Long N,K,T;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Long.parseLong(st.nextToken()); K = Long.parseLong(st.nextToken()); T = Long.parseLong(st.nextToken());
        
        TreeSet<Long> set = new TreeSet<>();
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            set.add(Long.parseLong(st.nextToken()));
        }
        for(int i=0;i<K;i++) {
            Long eat = set.floor(T);
        }
    }
}
