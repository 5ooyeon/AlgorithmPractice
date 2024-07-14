package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2_10816 {
    static int N, arr[], M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());

        getAns: for(int t=0;t<M;t++) {
            int target = Integer.parseInt(st.nextToken());

            int start = 0, end = N-1;
            while(start<=end) {

                int mid = (start + end) /2;

                if(arr[mid]==target) {
                    sb.append(cntNum(mid, target)+" "); continue getAns;
                } else if(arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            sb.append("0 ");
        }

        System.out.println(sb);

    }

    static int cntNum(int start, int target) {
        int cnt = 1, t = 1;
        while(true) {
            boolean isChanged = false;
            if(start-t>=0 && arr[start-t] == target) {
                cnt++; isChanged = true;
            }
            if(start+t<N && arr[start+t] == target) {
                cnt++; isChanged = true;
            }

            if(isChanged) {
                t++;
            } else {
                break;
            }
        }

        return cnt;
    }
}
