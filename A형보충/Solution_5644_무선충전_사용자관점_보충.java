
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
5
20 3
2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
4 4 1 100
7 10 3 40
6 3 2 70
*/

public class Solution_5644_무선충전_사용자관점_보충 {

	static int M,bcCnt; //이동시간 M, BC의 개수 bcCnt
	static int[] pathA, pathB, players[], bc[];
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		players = new int[2][2];
		
		for(int t=1; t<=TC; ++t) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); 
			bcCnt = Integer.parseInt(st.nextToken()); 

			players[0][0] = players[0][1] = 1; 
			players[1][0] = players[1][1] = 10; 
			
			pathA = new int[M+1]; 
			pathB = new int[M+1]; 
			bc = new int[bcCnt][4]; 
			
			String[] charsA = br.readLine().split(" ");
			String[] charsB = br.readLine().split(" ");
			for(int c=0; c<M; ++c) { 
				pathA[c+1] = charsA[c].charAt(0)-'0'; 
				pathB[c+1] = charsB[c].charAt(0)-'0'; 
			}
			
			for(int a=0; a<bcCnt; ++a) {
				st = new StringTokenizer(br.readLine());
				bc[a][0] = Integer.parseInt(st.nextToken()); //row
				bc[a][1] = Integer.parseInt(st.nextToken()); //col
				bc[a][2] = Integer.parseInt(st.nextToken()); //coverage
				bc[a][3] = Integer.parseInt(st.nextToken()); //performance
			}
			// ----------------input End
			System.out.println("#"+t+" "+move());
		}
	}
	
	static int move() {
		ArrayList<Integer> bcListA, bcListB; 
		int totalSum = 0;
		int time = 0;
		 while (time<=M){ 
			players[0][0] += dx[pathA[time]];
			players[0][1] += dy[pathA[time]];
			players[1][0] += dx[pathB[time]];
			players[1][1] += dy[pathB[time]];
			
			bcListA= getBc(players[0][0],players[0][1]);
			bcListB= getBc(players[1][0],players[1][1]);			

			totalSum += getCombinationMaxPower(bcListA,bcListB);
			time++;
		}
		return totalSum;
	}
	
	private static int getCombinationMaxPower(ArrayList<Integer> apListA, ArrayList<Integer> apListB) {
		int max  = 0,temp = 0;
		int aSize = apListA.size(), bSize = apListB.size();
		
		if(aSize == 0 && bSize == 0) return 0;

		else if(aSize==0) return getMaxPower(apListB);
		else if(bSize==0) return getMaxPower(apListA);

		for (Integer a : apListA) {
			for (Integer b : apListB) { 
				temp = Math.max(bc[a][3],bc[b][3]);
				if(a != b) temp += Math.min(bc[a][3], bc[b][3]); 
				max = Math.max(max,temp); 
			}
		}
		return max;
	}
	
	static int getMaxPower(ArrayList<Integer> bcList) {
		int max = 0;
		for (Integer a : bcList) {
			if(bc[a][3]>max) max = bc[a][3];
		}
		return max;
	}

	static ArrayList<Integer> getBc(int x, int y){
		ArrayList<Integer> bcList = new ArrayList<Integer>();
		int d=0;
		for(int a=0; a<bcCnt; ++a) {
			d = Math.abs(bc[a][0]-x)+Math.abs(bc[a][1]-y); 
			if(d<=bc[a][2])	bcList.add(a); 
		}
		return bcList;
	}
}
