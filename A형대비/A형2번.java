package A형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

	public class A형2번 {
		static class House{
			int x, y, boundary;
			
			House(int x, int y, int boundary) {
				this.x = x;
				this.y = y;
				this.boundary = boundary;
				
			}
		}
		static int N, arr[][];
		static LinkedList<House> houseList;
		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb= new StringBuilder();
			int t = Integer.parseInt(bf.readLine());
			StringTokenizer st;
			for(int tc = 1; tc <=t; tc++) {
				sb.append("#"+tc+" ");
				arr = new int[31][31];
				houseList = new LinkedList<>();
				
				//�� ����
				N = Integer.parseInt(bf.readLine());
				for(int i=0;i<N;i++) {
					st = new StringTokenizer(bf.readLine());
					House h = new House(15+Integer.parseInt(st.nextToken()),15+Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
					arr[h.x][h.y] = -1;
					houseList.add(h);
				}


				
				
				
				
				
				
				
				
				
//				sb.append(ans+"\n");
			}
			System.out.println(sb.toString());
		}
}
