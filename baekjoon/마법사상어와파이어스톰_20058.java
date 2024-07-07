package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법사상어와파이어스톰_20058 {
    static int arr[][], dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        arr = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];

        for(int i=0;i<arr.length;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<arr[i].length;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        while(!queue.isEmpty()) {
            int L = queue.poll();
            tornado((int) Math.pow(2, L));
        }


    }

    static void tornado(int l) {
        
    }

}
