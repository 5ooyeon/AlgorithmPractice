package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 배열돌리기4_17406 {
    static class Action {
        Coor fCoor, lCoor;
        Action(Coor fCoor, Coor lCoor) {
            this.fCoor = fCoor;
            this.lCoor = lCoor;
        }
    }
    static class Coor {
        int x, y;
        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, K, arr[][], ans;
    static LinkedList<Action> actionList;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        actionList = new LinkedList<>();
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        ans = Integer.MAX_VALUE;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
            Action a = new Action(new Coor(x-s-1, y-s-1), new Coor(x+s-1, y+s-1));
            actionList.add(a);
        }
        LinkedList<Integer> saveIdx = new LinkedList<>();
        getAction(saveIdx);
        System.out.println(ans);
    }
    static void getAction(LinkedList<Integer> saveIdx) {
        if(saveIdx.size() == actionList.size()) {
            System.out.println("처음 회전 좌표: "+actionList.get(0).fCoor.x);
            for(int i=0;i<N;i++) {
                int temp = 0;
                for(int j=0;j<M;j++) {
                    System.out.print(arr[i][j]+" ");
                    temp += arr[i][j];
                }
                // System.out.println("   , temp is "+temp+", ans is "+ans);
                ans = temp < ans ? temp : ans;
            }
            return;
        }

        for(int i=0;i<actionList.size();i++) {
            if(!saveIdx.contains(i)) {
                saveIdx.add(i);
                moveArr(actionList.get(i));
                getAction(saveIdx);
                saveIdx.removeLast();
                returnArr(actionList.get(i));
            }
        }

    }

    static void moveArr(Action action) {
        int x1 = action.fCoor.x, y1 = action.fCoor.y;
        int x2 =  action.lCoor.x, y2 = action.lCoor.y;
        while(x1<x2 && y1 < y2) {
            int temp = arr[x1][y1];

            for(int i=x1; i<x2;i++) {
                arr[i][y1] = arr[i+1][y1];
            }
            
            for(int i=y1; i<y2;i++) {
                arr[x2][i] = arr[x2][i+1];
            }
            
            for(int i=x2; i>x1;i--) {
                arr[i][y2] = arr[i-1][y2];
            }
            
            for(int i=y2; i>y1;i--) {
                arr[x1][i] = arr[x1][i-1];
            }
            arr[x1][y1+1] = temp;
            x1++; y1++; x2--; y2--;
        }
    }

    static void returnArr(Action action) {
        int x1 = action.fCoor.x, y1 = action.fCoor.y;
        int x2 =  action.lCoor.x, y2 = action.lCoor.y;
        System.out.println("x1 is "+x1+", y1 is "+y1+", x2 is "+x2+", y2 is "+y2);
        while(x1<x2 && y1 < y2) {
            int temp = arr[x1][y1];

            for(int i=y1; i<y2;i++) {
                arr[x1][i] = arr[x1][i+1];
            }
            
            for(int i=x1; i<x2;i++) {
                arr[i][y2] = arr[i+1][y2];
            }
            
            for(int i=y2; i>y1;i--) {
                arr[x2][i] = arr[x2][i-1];
            }
            
            for(int i=x2; i>x1;i--) {
                arr[i][y1] = arr[i-1][y1];
            }
            arr[x1+1][y1] = temp;
            x1++; y1++; x2--; y2--;
        }
    }
}
