package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석도둑_1202 {
    static class Jewel {
        int M, V;

        Jewel(int M, int V) {
            this.M = M;
            this.V = V;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<Jewel> jewels = new PriorityQueue<>(new Comparator<Jewel>() {

            @Override
            public int compare(Jewel o1, Jewel o2) {
                return Integer.compare(o1.M, o2.M);
            }
            
        });
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            jewels.offer(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for(int i=0;i<K;i++) {
            bags.offer(Integer.parseInt(bf.readLine()));
        }

        long ans = 0;
        PriorityQueue<Jewel> tempJewels = new PriorityQueue<>(new Comparator<Jewel>() {

            @Override
            public int compare(Jewel o1, Jewel o2) {
                if(o1.V == o2.V) {
                    return o1.M - o2.M;
                }
                return o2.V - o1.V;
            }
            
        });
        while(!bags.isEmpty()) {
            int bag = bags.poll();
            while(!jewels.isEmpty() && jewels.peek().M <= bag) {
                tempJewels.offer(jewels.poll());
            }
            if(tempJewels.isEmpty()) {
                continue;
            }
            ans += tempJewels.poll().V;
            System.out.println(ans);
        }
        System.out.println(ans);
    }
}
