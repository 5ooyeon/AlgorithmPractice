package baekjoon;

import java.io.*;
import java.util.*;

public class 아기상어_16236 {
    static class Shark {
        int x, y, size;
        Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
        }

        void moveShark(int x, int y) {
            babyShark.x = x;
            babyShark.y = y;
        }

        void levelUpShark() {
            babyShark.size++;
        }
    }

    static int arr[][], N;
    static Shark babyShark;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9) {
                    babyShark = new Shark(i, j);
                }
            }
        }

        

    }
}
