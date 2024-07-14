package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 토끼의이동_3101 {
    static int N, K;
    static long arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        
        arr = new long[2*N-1];
        arr[0] = 1;
        for (int i = 1; i < N; i++) {	//(0,0)부터 등차수열 형태로 증가
            arr[i] = arr[i-1] + i;
        }
        arr[2*N-2] = 1l*N*N;
        for (int i = 2; i < N; i++) {	//(n-1,n-1)부터 등차수열 형태로 감소
            arr[2*N-1-i] = arr[2*N-i] - i;
        }

        String input = bf.readLine();
        int x = 0, y = 0;
        long sum = 1;
        for (int i = 0; i < K; i++) {
            switch (input.charAt(i)) {
                case 'U':
                    x--;
                    break;
                case 'D':
                    x++;
                    break;
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;
                default:
                    break;
            }
            sum += arr[x+y] + getNum(x, y);
        }
        System.out.println(sum);
    }
    static long getNum(int x, int y) {
        if(x+y >= N) {
            x = N-1-x;
            y = N-1-y;
            int temp = x;
            x = y;
            y = temp;
        }
        return (x+y)%2 == 0 ? y : x;
    }
}
