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
            arr[i] = temp;
            sum += temp;
            queue.add(temp);
        }
        
        int money = sc.nextInt();
        
        if(money >= sum) {
        	System.out.println(queue.toArray()[N-1]);
        } else {
        	int a = 0; int yesan = 0;
        	while(money>=0 || arr[N-1]!= 0) {
        		for(int i=a;i<N;i++) {
        			money--;arr[i]--;
        			if(i==N-1 && arr[a]==0) {
        				System.out.println("yesan: "+yesan+", money: "+money);
        				a++;
        			}
        		}
        		System.out.println(++yesan);
        	}
        	System.out.println(yesan);
        }
    }
}
