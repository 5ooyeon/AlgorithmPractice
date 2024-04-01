package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 전력난_6497 {

    static class Road{
        int h1, h2, cost;

        Road(int h1, int h2, int cost) {
            this.h1 = h1;
            this.h2 = h2;
            this.cost = cost;
        }

    }

    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());

        arr = new int[M];

        for(int i=0;i<M;i++) {
            arr[i] = i;
        }

        TreeSet<Road> set = new TreeSet<>(new Comparator<Road>() {

            @Override
            public int compare(Road o1, Road o2) {
                if(o1.cost == o2.cost) {
                    return -1;
                }
                return o1.cost - o2.cost;
            }
            
        });

        int totalCost = 0;

        while(true) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken()),
            b = Integer.parseInt(st.nextToken());

            if(a==0 && b==0) {
                break;
            }

            int c = Integer.parseInt(st.nextToken());

            set.add(new Road(a, b, c));

            totalCost += c;
        }


        int cnt = 0, costSum = 0;
        while(cnt != M-1 && !set.isEmpty()) {
            Road r = set.pollFirst();

            int a = find(r.h1), b = find(r.h2);
            if(a!=b) {
                cnt++; costSum+= r.cost;
                arr[a] = b;
            }
        }

        System.out.println(totalCost - costSum);
    }

    static int find(int h1) {
        if(h1 == arr[h1]) {
            return h1;
        }

        return arr[h1] = find(arr[h1]);
    }
}
