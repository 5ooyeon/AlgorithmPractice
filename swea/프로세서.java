package swea;

import java.io.*;
import java.util.*;

public class 프로세서 {

    static class Cell {
        int x; int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, arr[][], cellAns, lengthAns;
    static ArrayList<Cell> cellList;
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for(int tc =1; tc<= t; tc++) {

            N = Integer.parseInt(bf.readLine());

            //Core 넣을 List만들기
            cellList = new ArrayList<>();

            //연결된 Core개수와 전선 길이의 합 초기화
            cellAns = -1;
            lengthAns = -1;

            //배열 초기화
            arr = new int[N][N];
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    //Core라면 List 안에 넣어주기
                    if(arr[i][j] == 1) {
                        cellList.add(new Cell(i, j));
                    }
                }
            }
            DFS(0, 0, 0);
            sb.append("#"+tc+" "+lengthAns+"\n");
        }
        System.out.print(sb.toString());
    }

    static void DFS(int cellIdx, int lengthCnt, int cellCnt) {
        //모든 cell 탐색을 끝냈다면
        if(cellIdx == cellList.size()) {

            // System.out.println("linelength is "+lineLength+", cellCnt is "+cellCnt);
            // for(int i=0;i<N;i++) {
            //     for(int j=0;j<N;j++) {
            //         System.out.print(arr[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            // System.out.println("---");


            //탐색한 core 수가 저장된것보다 더 많을 때 정보 갱신
            if(cellAns < cellCnt) {
                cellAns = cellCnt;
                lengthAns = lengthCnt;
                return;
            }
            //같은 코어 수라면 length 최대값일때만 정보 갱신
            if(cellAns == cellCnt) {
                if(lengthCnt < lengthAns) {
                    lengthAns = lengthCnt;
                    return;
                }
            }
            return;
        }
        //idx 대상 Cell
        Cell c = cellList.get(cellIdx);

        //Cell이 벽면에 붙어있어 전선이 필요가 없다면 cellCnt와 Idx 올려주고 dfs 호출
        if((c.x==0 || c.x == N-1) || (c.y == 0 || c.y == N-1)) {
            DFS(cellIdx+1, lengthCnt, cellCnt+1);
        } else {
            //line을 위, 우, 하, 좌 로 연결하는 것으로 부르스포트
            start : for(int dr=0;dr<4;dr++) {
                for(int x = dx[dr], y = dy[dr]; c.x+x<N && c.x+x>=0 && c.y+y<N && c.y+y>=0;x+=dx[dr], y+=dy[dr]) {
                    if(arr[c.x+x][c.y+y]!=0) {
                        continue start;
                    }
                }
                int temp = 0;
                for(int x = dx[dr], y = dy[dr]; c.x+x<N && c.x+x>=0 && c.y+y<N && c.y+y>=0;x+=dx[dr], y+=dy[dr]) {
                    temp++;
                    arr[c.x+x][c.y+y] = 5;
                }
                DFS(cellIdx+1, lengthCnt+temp, cellCnt+1);
                //전선 다시 지워주기
                for(int x = dx[dr], y = dy[dr]; c.x+x<N && c.x+x>=0 && c.y+y<N && c.y+y>=0;x+=dx[dr], y+=dy[dr]) {
                    arr[c.x+x][c.y+y] = 0;
                }
            }

            DFS(cellIdx+1, lengthCnt, cellCnt);
        }

    }
}
