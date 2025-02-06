/*
 * 
문제: 떡볶이 떡 만들기
문제 설명:
당신은 떡볶이 떡을 만드는 요리사입니다. 손님들은 떡볶이 떡의 총 길이 M(예: 6m 이상)을 요구합니다. 당신은 이미 여러 개의 떡을 가지고 있는데, 각 떡의 길이는 정수로 주어집니다.
각 떡을 일정 높이 H에서 잘라서, 잘린 위쪽 부분만 손님에게 제공합니다. 만약 떡의 길이가 H보다 작으면 그 떡은 잘리지 않고 넘어갑니다. (즉, 떡의 길이가 L일 때, L > H이면 (L - H)만큼의 떡이 손님에게 제공됩니다.)

목표:
손님의 요구(총 길이 M 이상)를 만족시키기 위해 떡을 자를 때, H의 최댓값을 구하세요.

입력 형식:

첫 줄에 떡의 개수 N과 손님이 원하는 떡볶이 떡의 총 길이 M이 공백으로 구분되어 주어집니다.
두 번째 줄에 N개의 떡의 길이가 공백으로 구분되어 주어집니다.
출력 형식:

떡볶이 떡의 총 길이가 M 이상이 되도록 떡을 자를 때의 H의 최댓값을 출력합니다.
예시 입력:

복사
4 6
19 15 10 17
예시 출력:

복사
15
 * 
 */


import java.io.*;
import java.util.*;

public class 떡볶이떡요리사 {
    static int N, M, tteok[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tteok = new int[N];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            tteok[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tteok);

        int left = 0, right = tteok[N - 1];
        int ans = 0;

        while (left <= right) {
            int mid = (left + right)/2;

            int sum = getTteok(mid);

            if(sum >= M) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }

        }

        System.out.println(ans);
    }

    private static int getTteok(int mid) {
        int returnNum = 0;
        for(int i=0;i<N;i++) {
            if(tteok[i] < mid) continue;
            returnNum += tteok[i] - mid;
        }

        return returnNum;
    }
}
