package baekjoon;

import java.io.*;
import java.util.*;

/**
 * N번째큰수_2075
 */
public class N번째큰수_2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int[][] arr = new int[N][2];
        String[] a = bf.readLine().split(" ");

        for(int i=0;i<a.length;i++) {
            queue.add(Integer.parseInt(a[i]));
        }

        for(int i=0;i<N-1;i++) {
            a = bf.readLine().split(" ");
            for(int j=0;j<a.length;j++) {
                queue.add(Integer.parseInt(a[j]));
                queue.poll();
            }
        }
        System.out.println(queue.poll());
    }
}