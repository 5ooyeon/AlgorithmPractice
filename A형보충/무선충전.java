package A형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 무선충전 {
    static class field {
        int x;
        int y;
        
        field(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static field[] direction = new field[5];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        direction[0] = new field(0, 0);
        direction[1] = new field(-1, 0);
        direction[2] = new field(0, 1);
        direction[3] = new field(1, 0);
        direction[4] = new field(0, -1);

        for(int tc=1;tc<=t;tc++) {
            StringTokenizer st= new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken()), bcSize = Integer.parseInt(st.nextToken());
            Queue<Integer>[] person = new LinkedList[2];
            for(int i=0;i<2;i++) {
                st = new StringTokenizer(bf.readLine());
                while(st.hasMoreTokens()) {
                    person[i].offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}
