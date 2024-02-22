package A형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 줄기세포배양 {

    static class Cell{
        int isAlive;
        int x;
        int y;
        int createdTime;
        int hp;
    
        PriorityQueue<Cell> list;
    
        @Override
        public String toString() {
            return "[isAlive=" + isAlive + ", x=" + x + ", y=" + y + ", createdTime=" + createdTime + ", hp=" + hp
                    + "]";
        }
    
        Cell() {
        }
    
        Cell(int x, int y, int createdTime, int hp, int isAlive) {
            this.x = x;
            this.y = y;
            this.createdTime = createdTime;
            this.hp = hp;
            this.isAlive = isAlive;
        }
    
        void putCell(Cell cell) {
            for(Cell c: list) {
                if(c.x== cell.x && c.y == cell.y) {
                    return;
                }
            }
            list.add(cell);
    
        }
    
        ArrayList<Cell> getCells(int time) {
    
            ArrayList<Cell> newList = new ArrayList<>();
    
            for(Cell c : list) {
                if(c.createdTime + c.hp + 1 == time) { //활성상태일경우 리스트 받아오기
                    // System.out.println("활성화되는 세포: "+c.toString());
                    newList.add(c);
                }
            }
            return newList;
        }
    
        void changeAlive(int time) {
            for(Cell c: list) {
                if(c.createdTime + c.hp == time) {
                    c.isAlive = 0; //활성상태
                } else if(c.createdTime + c.hp + c.hp == time) {
                    c.isAlive = -1; //비활성상태
                }
            }
        }
    
        int count(int time) {
            int cnt = 0;
            for(Cell c : list) {
                if(c.createdTime + c.hp + c.hp > time) {
                    cnt++;
                }
            }
            return cnt;
        }
    
        PriorityQueue<Cell> getAll() {
            return list;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        Cell c = new Cell();

        StringTokenizer st;
        for(int tc = 1; tc <= T; tc++) {

            c.list = new PriorityQueue<>(new Comparator<Cell>() {

                @Override
                public int compare(Cell o1, Cell o2) {
                    return o2.hp - o1.hp;
                }
                
            });

            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), timeLimit = Integer.parseInt(st.nextToken());

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<M;j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp!=0) {
                        Cell cell = new Cell(i, j, 0, temp, 1);
                        c.putCell(cell);
                    }
                }
            }

            for(int time = 1; time <= timeLimit; time++) {

                // c.changeAlive(time);

                ArrayList<Cell> cells = c.getCells(time);
                for(Cell cell : cells) {

                    int x = cell.x, y = cell.y;

                    c.putCell(new Cell(x-1, y, time, cell.hp, 1));
                    c.putCell(new Cell(x+1, y, time, cell.hp, 1));
                    c.putCell(new Cell(x, y-1, time, cell.hp, 1));
                    c.putCell(new Cell(x, y+1, time, cell.hp, 1));

                    // c.putCell(new Cell(x+1, y, time, cell.hp, 1));
                    // c.putCell(new Cell(x, y-1, time, cell.hp, 1));
                    // c.putCell(new Cell(x, y+1, time, cell.hp, 1));
                    
                }
                
            }

            // for(Cell cell : c.getAll()) {
            //     System.out.println(cell.toString());
            // }

            sb.append("#"+tc+" "+c.count(timeLimit)+"\n");

        }
        System.out.println(sb.toString());
    }
}
