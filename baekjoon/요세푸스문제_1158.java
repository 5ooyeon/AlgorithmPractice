package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 요세푸스문제_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), k = sc.nextInt();
        ArrayList<Integer> yosep = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=1;i<=N;i++) {
            yosep.add(i);
        }

        int currIdx = 0;
        while(!yosep.isEmpty()) {
            currIdx = (currIdx + k - 1)%yosep.size();
            ans.add(yosep.remove(currIdx));
        }
        String answer = ans.toString();
        answer = answer.replace("[", "<");
        answer = answer.replace("]", ">");
        System.out.println(answer);
    }
}
