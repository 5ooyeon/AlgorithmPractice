package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 대표선수_2461 {
    static int arr[][];
    static class Num {
        int classIdx,studentIdx, score;

        Num(int classIdx, int studentIdx) {
            this.classIdx = classIdx;
            this.studentIdx = studentIdx;
            this.score = arr[classIdx][studentIdx];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        int min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        int[] idx = new int[N];
        Arrays.fill(idx, 0);
        
        while(true) {
            int minV = Integer.MAX_VALUE, maxV = Integer.MIN_VALUE, minIdx = -1;
            int[][] idxValues = new int[N][2];
            PriorityQueue<Num> pq = new PriorityQueue<>(new Comparator<Num>() {

                @Override
                public int compare(Num o1, Num o2) {
                    if(o1.score == o2.score) {
                        return o1.studentIdx - o2.studentIdx;
                    }
                    return o1.score - o2.score;
                }
                
            });

            PriorityQueue<Num> maxPq = new PriorityQueue<>(new Comparator<Num>() {

                @Override
                public int compare(Num o1, Num o2) {
                    if(o1.score == o2.score) {
                        return o1.studentIdx - o2.studentIdx;
                    }
                    return o2.score - o1.score;
                }
                
            });

            for(int i=0;i<N;i++) {
                idxValues[i][0] = i;
                idxValues[i][1] = arr[i][idx[i]];
                pq.offer(new Num(i, idx[i]));
                maxPq.offer(new Num(i, idx[i]));
            }
            ans = Math.min(ans, (maxPq.peek().score - pq.peek().score));
            
            while (!pq.isEmpty()) {
                Num num = pq.poll();
                if(num.studentIdx == M-1) continue;
                idx[num.classIdx]++;
                break;
            }
            if(pq.isEmpty()) {
                break;
            }
        }
        System.out.println(ans);
    }
}
