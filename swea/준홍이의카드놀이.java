package swea;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 준홍이의카드놀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for(int tc = 1;tc<=N;tc++) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] arr = new int[n*m][2];
            for(int i=1;i<=n;i++) {
                for(int j = 1 ; j <= m ;j++) {
                    arr[i+j-1][0] = i+j;
                    arr[i+j-1][1]++;
                }
            }
            Arrays.sort(arr, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o2[1]==o1[1]) {
                        return o1[0] - o2[0];
                    }
                    return o2[1] - o1[1];
                }
                
            });
            System.out.print("#"+tc+" "+arr[0][0]+" ");
            int i=1;
            while(arr[i][1]==arr[0][1]) {
                System.out.print(arr[i++][0]+" ");
            }
            System.out.println();
        }
    }
}
