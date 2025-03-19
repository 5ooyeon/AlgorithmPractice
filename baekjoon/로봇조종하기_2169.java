package baekjoon;

import java.io.*;
import java.util.*;

public class 로봇조종하기_2169 {

	static int[] dx = {0, -1, 0}, dy = {1, 0, -1}; // bfs를 위한 델타 배열 생성(위로는 못 올라감)
	static int[][] mm, arr;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M]; // 유적 금화를 저장하는 배열
		mm = new int[N][M]; // 메모이제이션(위치, 방향 저장)

		// 유적 내 금화 저장
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

        // 가장 첫 행 계산하기 -> 우측으로밖에 가지 못함
        mm[0][0] = arr[0][0];
        for(int i=1;i<M;i++) {
            mm[0][i] = mm[0][i-1] + arr[0][i];
        }

        // 다음 행부터 위쪽에서 내려오거나, 왼쪽에서 오거나, 오른쪽에서 오거나..
        for(int i=1;i<N;i++) {
            int[] fromLeft = new int[M];
            int[] fromRight = new int[M];

            // 왼쪽의 시작과 오른쪽의 끝은, 위에서밖에 내려오지 못함.
            fromLeft[0] = mm[i-1][0] + arr[i][0];
            fromRight[M-1] = mm[i-1][M-1] + arr[i][M-1];

            for(int j=1;j<M;j++) {
                fromLeft[j] = Math.max(fromLeft[j-1], mm[i-1][j]) + arr[i][j];
                fromRight[M-1-j] = Math.max(fromRight[M-j], mm[i-1][M-1-j]) + arr[i][M-1-j];
            }

            // mm에 값 넣어주기
            for(int j=0;j<M;j++) {
                mm[i][j] = Math.max(fromLeft[j], fromRight[j]);
            }
        }

        System.out.println(mm[N-1][M-1]);
	}

}
