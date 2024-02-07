package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc;
        do {
            tc = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<8;i++) {
                q.offer(sc.nextInt());
            }
            int i = 1, temp = 1;
            while(q.peek()>0 && temp!=0) {
                temp = q.poll()-i;
                q.add(temp = temp <= 0 ? 0 : temp);
                i = i < 5 ? i+1 : 1;
            }
            System.out.print("#"+tc);
            while(!q.isEmpty()) {
                System.out.print(" "+q.poll());
            }
            System.out.println();
        } while (tc<10);
    }
}
