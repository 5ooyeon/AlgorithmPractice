package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홀수홀릭호석_20164 {

    static BufferedReader bf;
    static int N, min, max;

    static void init() {
        bf = new BufferedReader(new InputStreamReader(System.in));
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    static void input() {
        try {
            N = Integer.parseInt(bf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void output() {
        System.out.println(min + " " + max);
    }

    static void process(int num, int oddCount) {

        if (num<10) {
            min = Math.min(min, oddCount);
            max = Math.max(max, oddCount);
            return;
        }

        if (Integer.toString(num).length() == 2) {
            int newNum = (num/10) + (num%10);
            process(newNum, oddCount + countOdds(newNum));

        } else {
            String numString = Integer.toString(num);
            int length = numString.length();

            for (int i=1;i<length-1;i++) {
                for (int j=i+1;j<length;j++) {

                    int newNum = Integer.parseInt(numString.substring(0, i))
                    + Integer.parseInt(numString.substring(i, j))
                    + Integer.parseInt(numString.substring(j));

                    process(newNum, oddCount + countOdds(newNum));
                }
            }
        }
    }

    static int countOdds(int num) {
        int count = 0;
        while (num>0) {
            if ((num%10)%2 != 0) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    static int two(int num) {
        return (num/10) + (num%10);
    }

    public static void main(String[] args) {
        init();
        input();
        process(N, countOdds(N));
        output();
    }
}
