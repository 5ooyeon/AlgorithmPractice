package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ListofUniqueNumbers_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int arr[] = new int[N], cnt[] = new int[100001];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int q = 0;
        long ans = 0;

        for(int p=0;p<N;p++) {
            while(q<N && cnt[arr[q]] == 0) {
                cnt[arr[q]]++;
                q++;
            }

            ans += (q-p);
            cnt[arr[p]]--;

        }

        System.out.println(ans);

    }
}
