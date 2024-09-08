package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_14002 {
	static int N;
	static int[] list;
	static int[] dp;
	static int[] tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
        
		N = Integer.parseInt(bf.readLine()); 
		list = new int[N + 1];
		dp = new int[N + 1];
		tmp = new int[N + 1];
        
		int result = 0;
		int resultIdx = 0;
        
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(list[i] > list[j] && dp[j]+1 > dp[i]){
					dp[i] = dp[j] + 1;
					tmp[i] = j;
				}
			}
			if(dp[i] > result){
				result = dp[i];
				resultIdx = i;
			}
		} 
        
		int[] answer = new int[result];
		int index = resultIdx;

		for(int i = result - 1; i >= 0; i--) {
			answer[i] = list[index];
			index = tmp[index]; 
		}
        
		System.out.println(result);
        
		for(int i = 0; i < result; i++) {
            System.out.println(answer[i]);
		}

	}	
}
