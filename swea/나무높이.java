package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나무높이 {
    static int N, arr[][], maxHeight, oddCnt, evenCnt, wholeTree;
    public static void main(String[] args) throws IOException, InterruptedException {
        /*짝수날은 2 홀수날은 1 자란다. */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= t; tc++) {

            sb.append("#"+tc+" ");
            N = Integer.parseInt(bf.readLine());

            arr = new int[N][2];
            oddCnt = 0; wholeTree = 1;

            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<N;i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = arr[i][0] % 2 == 0 ? 0 : 1; //짝수일 때 0, 홀수일 때 1
                if(arr[i][1] == 1) {
                    oddCnt++;
                }
            }

            evenCnt = N - oddCnt;

            Arrays.sort(arr, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
                
            });
            maxHeight = arr[N-1][0];
            if(arr[0][0] == maxHeight) {
                sb.append("0\n");
            } else {
                sb.append(givemul(0)+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int givemul(int day) throws InterruptedException {

        while(wholeTree != N) {
            day++;
            // Thread.sleep(5000);
            // System.out.print("initial: ");
            // for(int i=0;i<arr.length;i++) {
            //     for(int j=0;j<2;j++) {
            //         System.out.print(arr[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            if(day%2 == 1) {
                //홀수인 날
                for(int i=0;i<arr.length-wholeTree;i++) {
                    if(arr[i][0]%2==1) {
                        arr[i][0]++;
                        arr[i][1] = arr[i][0] == maxHeight ? -1 : 0;
                        oddCnt--; evenCnt++;

                        // System.out.println("day is "+day+", i is "+i+", arr[i][0] is "+arr[i][0]+", arr[i][1] is "+arr[i][1]);

                        if(arr[i][1] == -1) {
                            wholeTree++;
                        }
                        break;
                    }
                }
            } else {
                //짝수인 날
                for(int i=0;i<arr.length-wholeTree;i++) {
                    if(arr[i][0] > 1) {
                        arr[i][0]+=2;
                        arr[i][1] = arr[i][0] == maxHeight ? -1 : 1;
                        oddCnt++; evenCnt--;
                        // System.out.println("day is "+day+", i is "+i+", arr[i][0] is "+arr[i][0]+", arr[i][1] is "+arr[i][1]);
                        if(arr[i][1] == -1) {
                            wholeTree++;
                        }
                        break;
                    }
                }
            }
            Arrays.sort(arr, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
                
            });
        }
        return day;
    }
}
