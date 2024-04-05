package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 등산로 {

    static class Coor implements Comparable<Coor>{
        int x, y, height;

        Coor(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height =height;
        }

        @Override
        public int compareTo(Coor o) {
            return Integer.compare(o.height, this.height);
        }
    }

    static int N, arr[][], K, visited[][], max;
    static PriorityQueue<Coor> pq;
    static List<Coor> maxHeights;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    
        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc<= t; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); 
            K = Integer.parseInt(st.nextToken());
    
            arr = new int[N][N];
            visited = new int[N][N];
            maxHeights = new ArrayList<>();
            max = 1;
            pq = new PriorityQueue<>();
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j =0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    pq.offer(new Coor(i, j, arr[i][j]));
                }
            }
    
            maxHeights.add(pq.poll());
            while(!pq.isEmpty() && maxHeights.get(0).height == pq.peek().height) {
                maxHeights.add(pq.poll());
            }

            for(int i=0;i<maxHeights.size();i++) {
                int startX = maxHeights.get(i).x;
                int startY = maxHeights.get(i).y;
                visited = new int[N][N];
                // System.out.println(startX+" :: "+ startY);
                getRoute(startX, startY, 1, 1); // 시작점부터 길이 1로 시작
            }
            // getRoute(2, 3, 1, 1);
            // getRoute(2, 4, 1, 1);
            sb.append("#"+tc+" "+max+"\n");
        }
        System.out.println(sb);
    }
    static void getRoute(int x, int y, int length, int cutting) {
        visited[x][y] = 1;
        // if(length>max){
        //     System.out.println(x+ " "+y+" "+length+" "+cutting);

        // }
        max = Math.max(max, length);
        for(int i=0;i<4;i++) {
            try {
                if(visited[x+dx[i]][y+dy[i]] == 0) {
                    if(arr[x+dx[i]][y+dy[i]] < arr[x][y]) {
                        getRoute(x+dx[i], y+dy[i], length+1, cutting);
                    } else if(arr[x+dx[i]][y+dy[i]] - K < arr[x][y] && cutting == 1) {
                        int temp = arr[x+dx[i]][y+dy[i]];
                        arr[x+dx[i]][y+dy[i]] = arr[x][y] -1;
                        getRoute(x+dx[i], y+dy[i], length+1, 0);
                        arr[x+dx[i]][y+dy[i]] = temp;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
        }
        visited[x][y] = 0;
    }
}
