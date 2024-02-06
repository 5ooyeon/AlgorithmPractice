package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 주사위쌓기_2116 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			List<Integer> temp = new ArrayList<>();
			while (st.hasMoreTokens()) {
				temp.add(Integer.parseInt(st.nextToken()));
			}
			int changeIdx = temp.get(3);
			temp.remove(3);
			temp.add(4, changeIdx);

			list.add(temp);
		}

		int maxSum = 0;

		for (int a = 1; a <= 6; a++) {

			int sum = 0;
			int addNum = 0;

			// 시작 밑면이 1일때부터 계산.
			int findIndex = list.get(0).indexOf(a);
			int b = list.get(0).get(5 - findIndex);
			addNum = 6;
			while (a == addNum || b == addNum) {
				addNum--;
			}
			sum += addNum;
			int A = b;

			for (int i = 1; i < list.size(); i++) {
				findIndex = list.get(i).indexOf(A);
				b = list.get(i).get(5 - findIndex);
				addNum = 6;
				while (A == addNum || b == addNum) {
					addNum--;
				}
				sum += addNum;
				A = b;
			}

			maxSum = maxSum > sum ? maxSum : sum;
		}

		System.out.println(maxSum);

	}
}