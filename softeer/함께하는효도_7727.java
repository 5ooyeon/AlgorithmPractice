package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 함께하는효도_7727 {

    static class Coor {
        int x;
        int y;

        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, arr[][], visited[][], maxFruits;
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    static Coor friends[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            friends[i] = new Coor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        maxFruits = 0;

    }

    static void getFriuts(int time, int fruits) {
        if(time == 3) {
            maxFruits = maxFruits > fruits ? maxFruits : fruits;
            return;
        }

    }
}
