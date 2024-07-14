package baekjoon;

import java.io.*;
import java.util.*;

public class 세수의합_2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        
        Arrays.sort(arr);
        
        Set<Integer> sumSet = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                for (int k = j; k < N; k++) {
                    sumSet.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }
        
        for (int i = N - 1; i >= 0; i--) {
            if (sumSet.contains(arr[i])) {
                System.out.println(arr[i]);
                return;
            }
        }
    }
}