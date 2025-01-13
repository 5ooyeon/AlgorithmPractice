package A형보충;

import java.util.*;
import java.io.*;

public class A형1번 {

	static int N, M, arr[][], ans, visited[][];
	static Integer[][] dp;
	static int[] dx = {-1, 1,0,0}, dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		for(int tc = 1; tc<= t; tc++) {
			sb.append("#"+tc+" ");
			StringTokenizer st = new StringTokenizer(bf.readLine());
			//�迭 �����
			N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			dp = new Integer[N][M];
			//�迭�� �� �־��ֱ�
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0;j<M;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int x = N-1; int y = 0;
			visited = new int[N][M];
			ans = Integer.MAX_VALUE;
			visited[x][y] = 1;
			
			dfs(x,y,0);
			
			sb.append(ans+"\n");
		}
		System.out.print(sb.toString());
	}
	static void dfs(int x, int y, int diffCnt) {
//		System.out.println("x is "+x+", y is "+y+", diffCnt is "+diffCnt);
		//���� diffCnt�� ans���� ū ��� return;
		if(diffCnt >= ans) {
			return;
		}
		
		//x�� y���� 3�ΰ�� �� �� �� return
		if(arr[x][y] == 3) {
			ans = diffCnt;
			return;
		}
		
		//�� �ϴ� diff������ֱ�
		for(int i=0;i<2;i++) {
			//1���������� �ö󰡱�
			for(int j=1;x+dx[i]*j >=0 && x+dx[i]*j <N;j++) {
				if(arr[x+dx[i]*j][y] != 0 && visited[x+dx[i]*j][y] != 1) {
					int diffCheck = Math.max(diffCnt, j);
					if(dp[x+dx[i]*j][y] != null) {
						if(dp[x+dx[i]*j][y]<= diffCheck) {
							break;
						}
					}
					dp[x+dx[i]*j][y] = diffCheck;
					visited[x+dx[i]*j][y] = 1;
					dfs(x+dx[i]*j, y, diffCheck);
					visited[x+dx[i]*j][y] = 0;
					break;
				}
			}
		}
		
		
		//�¿�� �׳�!
		for(int i=2;i<4;i++) {
			//���� üũ
			if(y+dy[i] < M && y+dy[i] >= 0) {
				if(arr[x][y+dy[i]] != 0 && visited[x][y+dy[i]] != 1) {
					if(dp[x][y+dy[i]] != null) {
						if(dp[x][y+dy[i]] <= diffCnt) {
							break;
						}
					}
					dp[x][y+dy[i]] 	= diffCnt;
					visited[x][y+dy[i]] = 1;
					dfs(x, y+dy[i], diffCnt);
					visited[x][y+dy[i]] = 0;
				}
			}
		}
	}
}