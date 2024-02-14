package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class coor {
    int x;
    int y;
    int cnt;

    coor() {

    }
    
    coor(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class 미로탐색_2178 {
    static char arr[][];
    static int visited[][];
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new char[N][];
        visited = new int[N][M];

        for(int i=0;i<N;i++) {
            arr[i] = bf.readLine().toCharArray();
        }
        
        findMiro(new coor(0, 0, 1));

        System.out.println(visited[N-1][M-1]);
    }
    private static void findMiro(coor coor) {
        int x = coor.x, y = coor.y, cnt = coor.cnt;
        
        visited[x][y] = cnt;

        if(coor.x == N-1 && coor.y == M-1) {
            return;
        }

        if(x+1 < N && arr[x+1][y] == '1'  && (visited[x+1][y] > cnt+1 || visited[x+1][y] == 0)) {
            findMiro(new coor(x+1, y, cnt+1));
        }
        if(x-1 > -1 && arr[x-1][y] == '1' && (visited[x-1][y] > cnt+1 || visited[x-1][y] == 0)) {
            findMiro(new coor(x-1, y, cnt+1));
        }
        if(y+1 < M && arr[x][y+1] == '1' && (visited[x][y+1] > cnt+1 || visited[x][y+1] == 0)) {
            findMiro(new coor(x, y+1, cnt+1));
        }
        if(y-1 > -1 && arr[x][y-1] == '1' && (visited[x][y-1] > cnt+1 || visited[x][y-1] == 0)) {
            findMiro(new coor(x, y-1, cnt+1));
        }


    }
}
