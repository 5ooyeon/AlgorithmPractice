package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 네트워크연결_1922 {

    static class Computers{
        int computer1;
        int computer2;
        int price;

        Computers(int computer1, int computer2, int price) {
            this.computer1 = computer1;
            this.computer2 = computer2;
            this.price = price;
        }
    }

    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()), M = Integer.parseInt(bf.readLine());

        TreeSet<Computers> set = new TreeSet<>(new Comparator<Computers>() {

            @Override
            public int compare(Computers o1, Computers o2) {
                if(o1.price == o2.price) {
                    return -1;
                }
                return o1.price - o2.price;
            }
            
        });

        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            set.add(new Computers(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
        }

        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = i;
        }

        int cnt = 0, priceSum = 0;
        while(cnt != N-1) {
            Computers c = set.pollFirst();
            int c1 = find(c.computer1), c2 = find(c.computer2);
            if(c1 != c2) {
                cnt++; priceSum += c.price;
                arr[c1] = c2;
            }
        }
        System.out.println(priceSum);
    }

    static int find(int com) {
        if(com == arr[com]) {
            return com;
        }

        return arr[com] = find(arr[com]);
    }
}
