package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 야구_17281 {
    static int inning, stats[][], maxScore;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        inning = Integer.parseInt(bf.readLine());
        stats = new int[inning][9];
        maxScore = 0;
        StringTokenizer st;
        for(int i=0;i<inning;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<9;j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        LinkedList<Integer> players = new LinkedList<>();
        dfs(players);
        System.out.println(maxScore);
    }
    static void dfs(LinkedList<Integer> players) {
        if(players.size() == 9) {
            int score = getScore(players);
            maxScore = maxScore > score ? maxScore : score;
            return;
        }
        if(players.size()==3) {
            players.add(0);
            dfs(players);
            players.removeLast();
        } else {
            for(int i=1;i<9;i++) {
                if(!players.contains((Integer) i)) {
                    players.add(i);
                    dfs(players);
                    players.removeLast();
                }
            }
        }


    }
    static int getScore(LinkedList<Integer> players) {
        int turn = 0;
        int score = 0;
        for(int currentInning = 0; currentInning < inning; currentInning++) {
            int[] base = new int[4];
            int outCnt = 0;
            while(outCnt < 3) {
                int power = stats[currentInning][players.get(turn)];
                switch (power) {
                    case 0:
                        outCnt++;
                        break;
                    case 1: case 2: case 3:
                        for(int i=3;i>=1;i--) {
                            if(base[i] != 0) {
                                try {
                                    base[i+power] = 1;
                                    base[i] = 0;
                                } catch (Exception e) {
                                    score++; base[i] = 0; continue;
                                }
                            }
                        }
                        base[power] = 1;
                        break;
                    case 4:
                        for(int i=3;i>0;i--) {
                            if(base[i] != 0) {
                                score++; base[i] = 0;
                            }
                        }
                        score++;
                        break;
                }
                turn++;
                turn%=9;
            }
        }
        return score;
    }
}
