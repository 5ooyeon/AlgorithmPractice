package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 도시분할계획_1647 {

    static int arr[];
    static class Road {
        int h1, h2, price;

        Road(int h1, int h2, int price) {
            this.h1 = h1;
            this.h2 = h2;
            this.price = price;
        }
    }

    static TreeSet<Road> set = new TreeSet<>(new Comparator<Road>() {

        @Override
        public int compare(Road o1, Road o2) {
            if(o1.price == o2.price) {
                return -1;
            }
            return o1.price - o2.price;
        }
        
    });
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = i;
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            set.add(new Road(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
        }
        int cnt = 0, valueSum = 0;
        while(cnt != N -2) {
            Road r = set.pollFirst();
            int a = find(r.h1), b = find(r.h2);
            if(a != b) {
                arr[a] = b;
                cnt++; valueSum += r.price;
            }
        }

        System.out.println(valueSum);
    }

    static int find(int h) {
        if(arr[h] == h) {
            return h;
        }
        return arr[h] = find(arr[h]);
    }
}
