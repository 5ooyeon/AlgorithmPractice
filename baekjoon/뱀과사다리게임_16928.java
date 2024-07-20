package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 뱀과사다리게임_16928 {
    static int N, M, ladder[][], snake[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        ladder = new int[N][2];
        snake = new int[M][2];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            ladder[i][0] = Integer.parseInt(st.nextToken());
            ladder[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ladder, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
         
        });

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            snake[i][0] = Integer.parseInt(st.nextToken());
            snake[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snake, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'compare'");
            }
            
        });

        for(int i=0;i<N;i++) {
            dfs(i, (ladder[i][0]-1)/6 +1);
        }
        
    }
    private static void dfs(int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dfs'");
    }

}
