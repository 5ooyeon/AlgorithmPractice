package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 예산_2512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int sum = 0;
        int temp = 0;
        for(int i=0;i<N;i++) {
            temp = sc.nextInt();
            sum += temp;
            queue.add(temp);
        }

        int ultMoney = sc.nextInt();

        if(sum <= ultMoney) {
            System.out.println();
        } else {
            temp = queue.poll();
            ultMoney -= temp*N;

        }

    }
}
