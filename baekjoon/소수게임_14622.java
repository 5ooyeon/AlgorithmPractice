package baekjoon;

import java.io.*;
import java.util.*;

public class 소수게임_14622 {
    static PriorityQueue<Integer>[] pq = new PriorityQueue[2];
    static Set<Integer> nums = new HashSet<>();
    static long score[] = new long[2];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        pq[0] = new PriorityQueue<>(Collections.reverseOrder());
        pq[1] = new PriorityQueue<>(Collections.reverseOrder());
        
        StringTokenizer st = null;
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<2;j++) {
                int target = Integer.parseInt(st.nextToken());
                if(nums.contains(target)) {
                    //이미 있는 수니깐 점수 -1000
                    score[j]-=1000;
                    continue;
                }

                //소수가 아닌 수를 부르게 될 경우
                if(target == 0 || !isPrime(target)) {
                    //소수 3개 미만이면 1000점
                    if(pq[(j+1)%2].size() < 3) {
                        score[(j+1)%2] += 1000;
                    } else {
                        int temp1 = pq[(j+1)%2].poll(),
                        temp2 = pq[(j+1)%2].poll();
                        score[(j+1)%2] += pq[(j+1)%2].peek();
                        pq[(j+1)%2].offer(temp1);
                        pq[(j+1)%2].offer(temp2);
                    }
                } else {
                    nums.add(target);
                    pq[j].offer(target);
                }
            }
        }
        if(score[0] > score[1]) System.out.println("소수의 신 갓대웅");
        else if(score[1] > score[0]) System.out.println("소수 마스터 갓규성");
        else System.out.println("우열을 가릴 수 없음");
    }
    public static boolean isPrime(int number) {
        // 1은 소수가 아님
        if (number <= 1) {
            return false;
        }
        // 2와 3은 소수임
        if (number == 2 || number == 3) {
            return true;
        }
        // 짝수와 3으로 나누어 떨어지는 수는 소수가 아님
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        // 5부터 숫자의 제곱근까지 검사, 6k ± 1 패턴 사용
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
