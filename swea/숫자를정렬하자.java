package swea;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 숫자를정렬하자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for(int tc = 1; tc <= N;tc++) {
            sc.nextLine();
            String[] temp = sc.nextLine().split(" ");
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(String a : temp) {
                pq.add(Integer.parseInt(a));
            }
            System.out.print("#"+tc);
            while(!pq.isEmpty()) {
                System.out.print(" "+pq.poll());
            }
        }
    } 
}
