package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2_12015 {
    static int N, arr[], map[], idx;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[N];
        idx = 0;
        map[idx] = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] > map[idx]) {
                map[++idx] = arr[i];
            } else {
                int pos = getIndex(arr[i]);
                map[pos] = arr[i];
            }
        }

        System.out.println(idx + 1);
    }

    private static int getIndex(int target) {
        int left = 0, right = idx;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (map[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
