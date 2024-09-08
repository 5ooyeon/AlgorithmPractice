package baekjoon;

import java.util.*;

/**
 * Chance!_31804
 */
public class Chance느낌표_31804 {
    static class Moolbab {
        boolean saidChance;
        int loc;

        Moolbab(boolean saidChance, int loc) {
            this.saidChance = saidChance;
            this.loc = loc;
        }
    }
    static int a, b;
    static boolean mm[][];
    static Queue<Moolbab> que = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt(); b = sc.nextInt();
        mm = new boolean[b+1][2];

        int time = 0;
        que.offer(new Moolbab(false, a));

        while(true) {
            Queue<Moolbab> queue = new ArrayDeque<>();

            while(!que.isEmpty()) {
                Moolbab mb = que.poll();
                int c = mb.saidChance == false ? 0 : 1;
                if(mb.loc == b) {
                    System.out.println(time); System.exit(0);
                }
                if(!mm[mb.loc+1][c]) {
                    mm[mb.loc+1][c] = true;
                    queue.offer(new Moolbab(mb.saidChance, mb.loc+1));
                }
                if(mb.loc*2 <= b && !mm[mb.loc*2][c]) {
                    mm[mb.loc*2][c] = true;
                    queue.offer(new Moolbab(mb.saidChance, mb.loc*2));
                }
                if(c!=1 && mb.loc*10 <= b && !mm[mb.loc*10][1]) {
                    mm[mb.loc*10][1] = true;
                    queue.offer(new Moolbab(true, mb.loc*10));
                }
            }
            
            time++;
            que = queue;
        }

    }
}