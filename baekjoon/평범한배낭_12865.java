package baekjoon;

import java.io.*;
import java.util.*;

public class 평범한배낭_12865 {
    static int N, K, save;
    static Bag bags[];
    static class Bag{
        int weight;
        int value;

        Bag(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        
    }
//     public static void main(String[] args) throws IOException {
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(bf.readLine());
//         N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
//         bags = new Bag[N];
//         int size = 0;
//         for(int i=0;i<N;i++) {
//             st = new StringTokenizer(bf.readLine());
//             int weight = Integer.parseInt(st.nextToken()), value = Integer.parseInt(st.nextToken());
//             if(weight <= K) {
//                 bags[size] = new Bag(weight, value);
//                 size++;
//             }
//         }
//         bags = Arrays.copyOf(bags, size);
//         Arrays.sort(bags);

//         // for(Bag b : bags) {
//         //     System.out.println(b.weight+" "+ b.value);
//         // }

//         save = 0;
//         dp(0, 0, 0);
//         System.out.println(save);
//     }
//     static void dp(int idx, int valueHap, int weightHap) {
//         if(weightHap > K) {
//             return;
//         }
//         if(valueHap > save) {
//             save = valueHap;
//         }

//         for(int i=idx;i<bags.length;i++) {
//             dp(i+1, valueHap + bags[i].value, weightHap + bags[i].weight);
//         }
//     }
}

