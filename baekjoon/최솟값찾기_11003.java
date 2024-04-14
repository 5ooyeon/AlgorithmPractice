package baekjoon;

// import java.io.*;
// import java.util.*;

// public class 최솟값찾기_11003 {
// 	public static void main(String[] args) throws IOException{
// 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
// 		StringBuilder sb = new StringBuilder();

// 		StringTokenizer st = new StringTokenizer(bf.readLine());
		
// 		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		
// 		Deque<int[]> deque = new ArrayDeque<>();
// 		st = new StringTokenizer(bf.readLine());
// 		for(int i=0; i<N; i++) {
// 			int num = Integer.parseInt(st.nextToken());

// 			while(!deque.isEmpty() && deque.peekLast()[0] > num) {
//                 deque.pollLast();
//             }
            
// 			deque.offer(new int[] {num,i});
// 			if(deque.peek()[1] < i -(L-1)) {
// 				deque.poll();
// 			}
// 			sb.append(deque.peek()[0]+" ");
// 		}
// 		bw.write(sb.toString());
// 		bw.flush();
// 	}
// }
// import java.io.*;
// import java.util.*;

// public class 최솟값찾기_11003 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//         StringTokenizer st = new StringTokenizer(bf.readLine());
        
//         int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        
//         Deque<Integer> deque = new ArrayDeque<>();
//         int[] arr = new int[N];
//         st = new StringTokenizer(bf.readLine());
//         for(int i=0; i<N; i++) {
//             arr[i] = Integer.parseInt(st.nextToken());

//             while(!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
//                 deque.pollLast();
//             }
            
//             deque.offer(i);
//             if(deque.peek() < i -(L-1)) {
//                 deque.poll();
//             }
//             bw.write(arr[deque.peek()] + " ");
//         }
//         bw.flush();
//     }
// }
