package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보호필름 {
    static int D, W, K, film[][], ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc<=T; tc++) {
            sb.append("#"+tc+" ");
            StringTokenizer st = new StringTokenizer(bf.readLine());
            D = Integer.parseInt(st.nextToken()); W = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
            film = new int[D][W];
            for(int i=0;i<D;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<W;j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = 987654321;
            
            

        }
    }

    public void makeFilm(int row, int cnt) {
        makeFilm(row+1, cnt);

        int[] temp = new int[W];
        for(int i=0;i<W;i++) {
            temp[i] = film[row][i];
        }


        yak(row, 0);
        makeFilm(row+1, cnt+1);

        yak(row, 1);
        // Arrays.fill(film[row], 1);
        makeFilm(row+1, cnt+1);

        //원상복구
        for(int i=0;i<W;i++) {
            film[row][i] = temp[i];
        }

    }

    private boolean isOk() {
        for(int i=0;i<W;i++) {
            boolean flag = true;
            int cnt = 1;

            for(int j=0;j<D;j++) {
                if(film[i][j] == film[i-1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                if(cnt >= K) {
                    flag = false;
                    break;
                }

            }

            if(!flag) {
                return false;
            }
            return true;
        }
    }


    public void yak(int row, int drug) {
        for(int i=0;i<W;i++) {
            film[row][i] = drug;
        }
    }
}
