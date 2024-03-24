package baekjoon;

import java.io.*;
import java.util.*;
 
public class 곱셈_1629 {
	public static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B));
	}
	public static long pow(long A, long B) {
		
		// 지수가 1일 경우 A^1 이므로 A를 그대로 리턴
		if(B == 1) {
			return A % C;
		}
		
		// 지수의 절반에 해당하는 A^(exponent / 2) 을 구한다.
		long temp = pow(A, B / 2);
		
		/*
		 * 현재 지수가 홀 수 였다면
		 * A^(exponent / 2) * A^(exponent / 2) * A 이므로
		 * A를 한 번 더 곱해주어야 한다.
		 * 
		 * ex) A^9 = A^4 * A^4 * A
		 */
		if(B % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;
	}
}