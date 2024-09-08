package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class 수묶기_1744 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int arr[] = new int[N];
        int max = 0;
        int zeroCnt = 0;
        for(int i=0;i<N;i++) { 
            arr[i] = Integer.parseInt(bf.readLine());
            max += arr[i];
            if(arr[i] == 0) {
                zeroCnt++;
            }
        }
        Arrays.sort(arr);
        for(int i=N-1;i>0 && arr[i-1] >= 0;i--) {
            int newNum = arr[i] * arr[i-1];
            int newMax = max - arr[i] - arr[i-1] + newNum;
            if(max >= newMax) {
                continue;
            } else {
                max = newMax;

                if(arr[i] == 0) {
                    zeroCnt--;
                }
                if(arr[i-1] == 0) {
                    zeroCnt--;
                }
                i--;
            }
        }

        for(int i=0;i<N-1 && arr[i+1] <= (zeroCnt!=0 ? 0 : -1); i++) {
            int newNum = arr[i] * arr[i+1];
            int newMax = max - arr[i] - arr[i+1] + newNum;
            if(max >= newMax) {
                continue;
            } else {
                max = newMax;
                i++;
            }
        }
         System.out.println(max);
    }
}
