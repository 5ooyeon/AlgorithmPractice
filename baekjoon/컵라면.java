package baekjoon;

import java.io.*;
import java.util.*;

public class 컵라면 {
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(bf.readLine());
    	
    	int[][] arr = new int[N][2];
    	StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for(int i=0;i<N;i++) {
    		st= new StringTokenizer(bf.readLine());
    		arr[i][0] = Integer.parseInt(st.nextToken()); //deadline
    		arr[i][1] = Integer.parseInt(st.nextToken()); //cupramen
    	}
    	
    	//컵라면 개수로 정렬
    	Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o2[0] - o1[0];
				}
				return o2[1] - o1[1];
			}
		});
    	
    	int sum = 0;
        Boolean[] ramenSum = new Boolean[N];
        int ramenCnt = 0;

    	for(int i=0;i<arr.length;i++) {
    		int temp = arr[i][0]-1;
            if(ramenSum[temp]==null) {
                ramenSum[temp] = true;
                sum += arr[i][1];
                ramenCnt++;
            } else if(temp!=0) {
                int idx = checkNull(ramenSum, temp);
                if(idx!=-1) {
                    ramenSum[idx] = true; ramenCnt++; sum += arr[i][1];
                }
            }
            if(ramenCnt==N) {
                break;
            }
    	}
    	System.out.println(sum);
	}

    private static int checkNull(Boolean[] ramenSum, int temp) {
        for(int i = temp; i >=0; i--) {
            if(ramenSum[i]==null) {
                return i;
            }
        }
        return -1;
    }
}