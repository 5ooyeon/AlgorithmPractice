package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {
    static int N, K, save;
    static Bag bags[];
    static class Bag {
        int weight;
        int value;

        Bag(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        bags = new Bag[N];
        int idx = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken()), value = Integer.parseInt(st.nextToken());
            if(weight <= K) {
                bags[idx] = new Bag(weight, value);
                idx++;
            }
        }

        Arrays.sort(bags, new Comparator<Bag>() {

            @Override
            public int compare(Bag o1, Bag o2) {
                if(o1.weight == o2.weight) {
                    return o2.value - o1.value;
                }
                return o1.weight - o2.weight;
            }
            
        });

        // for(Bag b : bags) {
        //     System.out.println(b.weight+" "+ b.value);
        // }

        save = 0;
        dp(0, 0, 0);
        System.out.println(save);
    }
    static void dp(int idx, int valueHap, int weightHap) {
        if(weightHap > K) {
            return;
        }
        if(valueHap > save) {
            save = valueHap;
        }

        for(int i=idx;i<bags.length;i++) {
            dp(i+1, valueHap + bags[i].value, weightHap + bags[i].weight);
        }
    }
}
