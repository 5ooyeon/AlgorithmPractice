package baekjoon;

import java.io.*;
import java.util.*;

public class Godzilla_11627 {
    static class Location {
        int x, y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Location godzilla;
    static Queue<Location> mech;
    static int n, m, resCnt, ans, godzillaMap[][];
    static char arr[][];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());

        tc : for(int tc = 1; tc<=t ; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
            arr = new char[n][m]; godzillaMap = new int[n][m];
            mech = new ArrayDeque<>();
            resCnt = 0; ans = 0;

            for(int i=0;i<n;i++) {
                arr[i] = bf.readLine().toCharArray();
                for(int j=0;j<m;j++) {
                    if(arr[i][j] == 'G') {
                        godzilla = new Location(i, j);
                        godzillaMap[i][j] = 1;
                    } else if(arr[i][j] == 'M') {
                        mech.offer(new Location(i, j));
                    } else if(arr[i][j] == 'R') {
                        resCnt++;
                    }
                }
            }

            //실행
            while(resCnt !=  0) {
                if(checkMate()) {
                    System.out.println(ans);
                    continue tc;
                }
                moveGodzilla();

                // println();
                
                if(checkMate()) {
                    System.out.println(ans);
                    continue tc;
                }

                moveMech();

                // println();


            }
            System.out.println(ans);
        }
    }

    public static void moveGodzilla() {
        //집 있는경우 집 부수기
        for(int i=0;i<4;i++) {
            int x = godzilla.x+dx[i], y = godzilla.y+dy[i];
            try {
                if(arr[x][y] == 'R') {
                    arr[godzilla.x][godzilla.y] = 'X';
                    godzillaMap[x][y] = 1;
                    godzilla.x = x; godzilla.y = y;
                    arr[x][y] = 'G';
                    resCnt--; ans++;
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
        }

        //이동만 하기
        for(int i=0;i<4;i++) {
            int x = godzilla.x+dx[i], y = godzilla.y+dy[i];
            try {
                if(arr[x][y] == '.' && godzillaMap[x][y] != 1) {
                    arr[godzilla.x][godzilla.y] = 'X';
                    godzillaMap[x][y] = 1;
                    godzilla.x = x; godzilla.y = y;
                    arr[x][y] = 'G';
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // TODO: handle exception
            }
        }

    }

    public static void moveMech() {
        Queue<Location> returnMech = new ArrayDeque<>();
        while (!mech.isEmpty()) {
            Location m = mech.poll();
            for(int i=0;i<4;i++) {
                int x = m.x+dx[i], y = m.y+dy[i];
                try {
                    if(arr[x][y] == '.' || arr[x][y] == 'X') {
                        returnMech.offer(new Location(x, y));
                        arr[x][y] = 'M';
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // TODO: handle exception
                }
            }
        }
        mech = returnMech;

    }

    private static boolean checkMate() {
        int x = godzilla.x, y = godzilla.y;
        a : for(int i = 0; i < 4;i++) {
            int j =1;
            while(true) {
                try {
                    if(arr[x+dx[i]*j][y+dy[i]*j] == '.' || arr[x+dx[i]*j][y+dy[i]*j] == 'X') {
                        j++;
                        continue;
                    } else if(arr[x+dx[i]*j][y+dy[i]*j] == 'M') {
                        return true;
                    } else {
                        continue a;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue a;
                }
            }
        }
        return false;
    }

    public static void println() {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("********");
    }

}
