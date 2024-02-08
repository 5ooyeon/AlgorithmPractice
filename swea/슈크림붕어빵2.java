package swea;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 슈크림붕어빵2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int n, m, k;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] temp;
        for(int tc=1;tc<=N;tc++) {
            temp = sc.nextLine().split(" ");
            pq.clear();
            n= Integer.parseInt(temp[0]);
            m= Integer.parseInt(temp[1]);
            k= Integer.parseInt(temp[2]);

            temp = sc.nextLine().split(" ");

            for(int i=0;i<n;i++) {
                pq.add(Integer.parseInt(temp[i]));
            }

            for(int i=1;i<=n;i++) {
                if(pq.poll() / m * k < i) {
                    System.out.println("#"+tc+" Imossible"); pq.add(1); break;
                }
            }
            if(pq.isEmpty()) {
                System.out.println("#"+tc+" Possible");
            }
        }
    }
}
