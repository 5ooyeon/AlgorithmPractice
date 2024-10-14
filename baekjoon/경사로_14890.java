package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로_14890 {
    static int N, L, arr[][];
    static boolean[][] useStairs;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        useStairs = new boolean[N][N];
        newrow: for(int i=0;i<N;i++) {

            for(int j=0;j<N-1;j++) {
                //가로
                if(arr[i][j] == arr[i][j+1]) {
                    continue;
                } else if(Math.abs(arr[i][j] - arr[i][j+1]) != 1) {
                    continue newrow;
                } else if(arr[i][j] - arr[i][j+1] == 1 && !useStairs[i][j+1] && checkStairs(i, j, 0)) {
                    continue;
                } else if(arr[i][j] - arr[i][j+1] == -1 && !useStairs[i][j] && checkStairs(i, j, 0)) {
                    continue;
                }
                else {
                    continue newrow;
                }

            }
            ans++;

        }

        useStairs = new boolean[N][N];
        newcol: for(int i=0;i<N;i++) {

            for(int j=0;j<N-1;j++) {
                //가로
                if(arr[j][i] == arr[j+1][i]) {
                    continue;
                } else if(Math.abs(arr[j][i] - arr[j+1][i]) != 1) {
                    continue newcol;
                } else if(arr[j][i] - arr[j+1][i] == 1 && !useStairs[j+1][j] && checkStairs(j, i, 0)) {
                    continue;
                } else if(arr[j][i] - arr[j+1][i] == -1 && !useStairs[j][i] && checkStairs(j, i, 0)) {
                    continue;
                } else {
                    continue newcol;
                }

            }
            ans++;

        }
        System.out.println(ans);
    }

    private static boolean checkStairs(int i, int j, int dir) {
        try {
            for(int idx=1;idx<L;idx++) {
                if(dir == 0) {
                    if(arr[i][j+idx] != arr[i][j+idx+1]) {
                        return false;
                    }
                } else {
                    if(arr[i+idx][j] != arr[i+idx+1][j]) {
                        return false;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        


        return true;
    }
}
