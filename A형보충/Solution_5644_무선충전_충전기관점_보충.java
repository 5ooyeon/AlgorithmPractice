import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전_충전기관점_보충{

	static int M,aCnt;
	static int[] pathA, pathB, players[], ap[];
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		players = new int[2][2];
		
		for(int t=1; t<=TC; ++t) {
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken()); 
			aCnt = Integer.parseInt(st.nextToken()); 
			
			players[0][0] = players[0][1] = 1;
			players[1][0] = players[1][1] = 10;
			
			pathA = new int[M+1];
			pathB = new int[M+1];
			ap = new int[aCnt][4];
			 
			String[] charsA = in.readLine().split(" ");
			String[] charsB = in.readLine().split(" ");
			for(int c=0; c<M; ++c) {
				pathA[c+1] = charsA[c].charAt(0)-'0'; 
				pathB[c+1] = charsB[c].charAt(0)-'0'; 
			}
			
			for(int a=0; a<aCnt; ++a) {
				st = new StringTokenizer(in.readLine());
				ap[a][0] = Integer.parseInt(st.nextToken());
				ap[a][1] = Integer.parseInt(st.nextToken()); 
				ap[a][2] = Integer.parseInt(st.nextToken()); 
				ap[a][3] = Integer.parseInt(st.nextToken()); 
			}
			//---------input end
			System.out.println("#"+t+" "+move());
		}
	}

	static int move() {
		int totalSum = 0;
		for(int time=0; time<=M; ++time){
			players[0][0] += dx[pathA[time]];
			players[0][1] += dy[pathA[time]];
			players[1][0] += dx[pathB[time]];
			players[1][1] += dy[pathB[time]];
			
			totalSum += getCharge();
		}
		
		return totalSum;
	}

	static int getCharge() {
		int max = 0;
		for(int a=0; a<aCnt; ++a) {
			for (int b = 0;  b< aCnt; ++b) {
				int sum = 0;
				int aSum = check(a,players[0][0],players[0][1]);
				int bSum = check(b,players[1][0],players[1][1]);
				if(a != b) { 
					sum = aSum + bSum; 
				}else {
					sum = Math.max(aSum, bSum);
				}
				if(max<sum) max = sum; 
			}
		}
		return max;
	}

	static int check(int a, int x, int y) {
		return Math.abs(ap[a][0]-x)+Math.abs(ap[a][1]-y) <= ap[a][2] ? ap[a][3] : 0;
	}
}
