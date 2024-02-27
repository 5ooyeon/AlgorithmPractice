package swea;

import java.io.*;
import java.util.*;

public class 햄버거다이어트 {

    static class Food {
        int score;
        int cal;

        Food(int score, int cal) {
            this.score = score;
            this.cal = cal;
        }
    }

    static Food[] foodList;
    static int maxCal;
    static int maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken());
            maxCal = Integer.parseInt(st.nextToken());
            foodList = new Food[n];
            maxScore = 0;

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(bf.readLine());
                Food f = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                foodList[i] = f;
            }

            findMaxScore(0, 0, 0);

            sb.append("#" + tc + " " + maxScore + "\n");
        }
        System.out.println(sb.toString());
    }

    static void findMaxScore(int currentScore, int currentCal, int index) {
        if (currentCal > maxCal) {
            return;
        }

        maxScore = Math.max(maxScore, currentScore);

        for (int i = index; i < foodList.length; i++) {
            findMaxScore(currentScore + foodList[i].score, currentCal + foodList[i].cal, i + 1);
        }
    }
}
