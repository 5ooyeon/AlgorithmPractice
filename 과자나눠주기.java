/*
현서는 자신의 N명의 조카들에게 과자를 나눠주려고 합니다. 과자는 M개가 있으며, 각각의 과자는 다른 길이를 가지고 있습니다. 
현서는 조카들에게 공평하게 과자를 나눠주고 싶습니다. 즉, 각 조카가 받는 과자의 길이는 모두 같아야 합니다.

과자는 길이와 상관없이 한 번만 자를 수 있으며, 과자를 하나도 받지 못하는 조카가 있어서는 안 됩니다.
이때 조카 한 명당 최대 몇 cm의 과자를 받을 수 있는지 구하는 프로그램을 작성하세요.

입력:
- 첫째 줄에 조카의 수 N(1 ≤ N ≤ 1,000,000), 과자의 수 M(1 ≤ M ≤ 1,000,000)이 주어집니다.
- 둘째 줄에 과자의 길이 L1, L2, ..., LM이 공백으로 구분되어 주어집니다. (1 ≤ Li ≤ 1,000,000,000)

출력:
- 조카 한 명이 받을 수 있는 과자의 최대 길이를 출력합니다.
- 모든 조카에게 같은 길이의 과자를 나눠줄 수 없다면 0을 출력합니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 과자나눠주기 {
    static int N, M, cookies[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cookies = new int[M];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cookies);

        int left = 1, right = cookies[M - 1];
        int ans = 0;

        while (left <= right) {
            int mid = (int) (((long) left + right) / 2);
            int result = getCookies(mid);

            if(result >= N) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static int getCookies(int mid) {
        int returnNum = 0;
        for(int i=0;i<M;i++) {
            returnNum += cookies[i]/mid;
        }

        return returnNum;
    }
}
