package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 턴게임_12934 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long x = Long.parseLong(st.nextToken()), y = Long.parseLong(st.nextToken());

        long S = x + y;

        // n을 계산합니다
        long n = (long) ((Math.sqrt(8 * (x + y) + 1) - 1) / 2);

        // n(n + 1) / 2가 S와 같은지 확인합니다
        if (n * (n + 1) / 2 != x + y) {
            System.out.println("-1");
            return;
        }

        // 최소 몇 번을 이겨야 x 점수를 얻을 수 있는지 계산
        long currentSum = 0;
        int turns = 0;
        System.out.println(n);
        for (long i = n; i > 0; i--) {
            if (currentSum + i <= x) {
                currentSum += i;
                turns++;
            }
            if (currentSum == x) {
                break;
            }
        }

        if (currentSum != x) {
            System.out.println("-1");
        } else {
            System.out.println(turns);
        }

    }
}
