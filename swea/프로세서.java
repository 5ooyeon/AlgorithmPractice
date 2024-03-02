package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 프로세서 {

    static class Cell{
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, arr[][];
    static ArrayList<Cell> cellList = new ArrayList<>();
    static HashSet<Integer> xSet = new HashSet<>();
    static HashSet<Integer> ySet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <=t ; tc++) {
            n = Integer.parseInt(bf.readLine());
            arr = new int[n][n];
            for(int i=0;i<n;i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<n;j++) {
                    String temp = st.nextToken();
                    arr[i][j] = Integer.parseInt(temp);
                    if(temp.equals("1")) {
                        cellList.add(new Cell(i, j));
                        xSet.add(i);
                        ySet.add(j);
                    }
                }
            }

            //--input 완료
            for(Cell c : cellList) {
                if(c.x==0 || c.x==n || c.y==0 || c.y==n) {
                    continue;
                }
                
            }


        }
    }
}
