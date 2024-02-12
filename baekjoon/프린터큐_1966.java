package baekjoon;

import java.util.*;

public class 프린터큐_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int tc = 0; tc<N;tc++) {
            pq.clear();
            q.clear();
            int size = sc.nextInt(), idx = sc.nextInt();
            int[][] arr = new int[size][2];
            for(int i=0;i<size;i++) {
                arr[i][0] = i;
                arr[i][1] = sc.nextInt();
                q.add(arr[i]); pq.add(arr[i][1]);
            }
            int cnt = 0;
            while(cnt < size) {
                while(pq.peek() != q.peek()[1]) {
                    int[] temp = q.poll();
                    q.add(temp);
                }
                if(idx == q.peek()[0]) {
                    System.out.println(++cnt); break;
                } else {
                    pq.poll();
                    q.poll(); cnt++;
                }

            }
        }
    }
}

