package swea;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 슈크림붕어빵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int n, m, k;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int tc=1;tc<=N;tc++) {
            pq.clear();
            n= sc.nextInt();
            m= sc.nextInt();
            k= sc.nextInt();
            sc.nextLine();
            String[] temp = sc.nextLine().split(" ");

            for(int i=0;i<n;i++) {
                pq.add(Integer.parseInt(temp[i]));
            }

            int timeSum = pq.peek(); //흐른 시간 

            if(timeSum<m) {
                System.out.println("impossible"); continue;
            }

            int taiyaki = timeSum/m * k - 1; //있는 붕어빵 개수
            int cnt = 1; //받은사람

            while(cnt < n) {
                int t1 = pq.poll();
                int t2 = pq.peek();
                if(cnt++ < 1) {
                    System.out.println("impossible"); break;
                }
                cnt++;
            }
            if(cnt==n) {
                System.out.println("possible");
            }
        }
    }
}
