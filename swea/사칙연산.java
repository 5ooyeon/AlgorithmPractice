package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사칙연산 {
    static String[] input;
    static int[] getNum;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1 ; tc <= 10 ; tc++) {
            int N = Integer.parseInt(bf.readLine());
            getNum = new int[N+1];
            input = new String[N+1];
    
            for(int i=0;i<N;i++) {
                String getInput = bf.readLine();
                String[] array = getInput.split(" ");
                input[Integer.parseInt(array[0])] = getInput;
            }
            getSum(1);
            sb.append("#"+tc+" "+getNum[1]+"\n");
        }
        System.out.println(sb.toString());
    }

    static int getSum(int num) {
        String[] array = input[num].split(" ");
        if(array.length>2) {
            switch (array[1]) {
                case "+":
                    return getNum[Integer.parseInt(array[0])] = getSum(Integer.parseInt(array[2])) + getSum(Integer.parseInt(array[3]));
                case "-":
                    return getNum[Integer.parseInt(array[0])] = getSum(Integer.parseInt(array[2])) - getSum(Integer.parseInt(array[3]));
                case "*":
                    return getNum[Integer.parseInt(array[0])] = getSum(Integer.parseInt(array[2])) * getSum(Integer.parseInt(array[3]));
                case "/":
                    return getNum[Integer.parseInt(array[0])] = getSum(Integer.parseInt(array[2])) / getSum(Integer.parseInt(array[3]));
            }
        } else {
            return getNum[Integer.parseInt(array[0])] = Integer.parseInt(array[1]);
        }
        return 0;
    }
}
