package baekjoon;

import java.io.BufferedReader;

public class Lazy_27427 {
    static class Road implements Comparable<Road> {
        long a, b, work, profit;

        @Override
        public int compareTo(Road o) {
            if(o.work == this.work) {
                return this.profit - o.profit;
            }
            return o.work - this.work;
        }

        Road(int a, int b, long work, long profit) {
            this.a = a;
            this.b = b;
            this.work = work;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(null);
    }
}
