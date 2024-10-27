package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 대표선수_2461 {
    static int[][] arr;

    static class Num {
        int classIdx, studentIdx, score;

        Num(int classIdx, int studentIdx, int score) {
            this.classIdx = classIdx;
            this.studentIdx = studentIdx;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        // 입력 받고 각 반 학생들의 점수를 오름차순으로 정렬
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        int ans = Integer.MAX_VALUE;

        // 초기 우선순위 큐 설정 (최소 힙)
        PriorityQueue<Num> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.score, o2.score));
        int maxScore = Integer.MIN_VALUE;

        // 각 반의 첫 번째 학생을 우선순위 큐에 넣음
        for (int i = 0; i < N; i++) {
            pq.offer(new Num(i, 0, arr[i][0]));
            maxScore = Math.max(maxScore, arr[i][0]);
        }

        // 최소 범위를 찾기 위한 루프
        while (true) {
            Num minNum = pq.poll();
            ans = Math.min(ans, maxScore - minNum.score);

            // 해당 반의 다음 학생으로 이동
            if (minNum.studentIdx + 1 < M) {
                int nextScore = arr[minNum.classIdx][minNum.studentIdx + 1];
                pq.offer(new Num(minNum.classIdx, minNum.studentIdx + 1, nextScore));
                maxScore = Math.max(maxScore, nextScore);
            } else {
                // 더 이상 해당 반의 학생이 없으면 종료
                break;
            }
        }

        System.out.println(ans);
    }
}
