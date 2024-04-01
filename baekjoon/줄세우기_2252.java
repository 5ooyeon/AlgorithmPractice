package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        ArrayList<Integer>[] list = new ArrayList[N];

        for(int i=0;i<N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            list[a].add(b);
            arr[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<N;i++) {
            if(arr[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append((cur+1)+" ");

            for(int n : list[cur]) {
                arr[n]--;
                if(arr[n] == 0) {
                    queue.offer(n);
                }
            }
        }
        System.out.println(sb);
    }
}
