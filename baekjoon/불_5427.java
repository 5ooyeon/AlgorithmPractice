package baekjoon;

import java.io.*;
import java.util.*;

public class 불_5427 {

    static class Coor {
        int x, y;

        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, visited[][];
    static char arr[][];
    static Coor Person;
    static Queue<Coor> fires, people;
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    static boolean getOut, isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            arr = new char[n][m];
            visited = new int[n][m];
            fires = new ArrayDeque<>();
            people = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                arr[i] = bf.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    switch (arr[i][j]) {
                        case '*':
                            fires.offer(new Coor(i, j));
                            break;
                        case '@':
                            visited[i][j] = 1;
                            people.offer(new Coor(i, j));
                            break;
                        default:
                            break;
                    }
                }
            }
            int time = 0;
            isPossible = true;
            getOut = false;
            while (isPossible && !getOut) {
                time++;
                fireBfs();
                personBfs();
            }

            if (!isPossible || !getOut) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(time);
            }

        }
    }

    private static void fireBfs() {
        Queue<Coor> returningQueue = new ArrayDeque<>();
        while (!fires.isEmpty()) {
            Coor fire = fires.poll();

            for (int i = 0; i < 4; i++) {
                int x = fire.x + dx[i], y = fire.y + dy[i];
                
                try {
                    if (arr[x][y] != '#' && arr[x][y] != '*') {
                        arr[x][y] = '*';
                        returningQueue.offer(new Coor(x, y));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // TODO: handle exception
                }
            }
        }
        fires = returningQueue;
    }

    static void personBfs() {

        Queue<Coor> persons = new ArrayDeque<>();

        while (!people.isEmpty()) {

            Coor person = people.poll();

            for (int i = 0; i < 4; i++) {
                int x = person.x + dx[i], y = person.y + dy[i];
                try {
                    if (visited[x][y] == 0 && arr[x][y] == '.') {
                        visited[x][y] = 1;
                        persons.offer(new Coor(x, y));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    getOut = true;
                    return;
                }
            }

        }

        if (persons.isEmpty()) {
            isPossible = false;
        }
        people = persons;

    }
}
