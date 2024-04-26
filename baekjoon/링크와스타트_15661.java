package baekjoon;

import java.io.*;
import java.util.*;

public class 링크와스타트_15661 {
    static int n, arr[][], totalHap, ans;
    static HashSet<Integer> team;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        team = new HashSet();
        StringTokenizer st;
        totalHap = 0;
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                totalHap += arr[i][j];
            }
        }
        team.add(0);
        getSet(0);

        System.out.println(ans);
    }

    static void getSet(int idx) {
        if (team.size() == n / 2) {
            // 여기서 부분집합 두개씩 고르는 함수 실행
            getTwo(team);
            return;
        }

        for (int i = idx + 1; i < n; i++) {
            team.add(i);
            getSet(i);
            team.remove(i);
        }
    }

    static void getTwo(HashSet<Integer> team) {
        // System.out.println("team has "+team.toString());
        int hap = 0, reverseHap = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (team.contains(i)) {
                    if (team.contains(j)) {
                        hap += arr[i][j];
                    }
                } else {
                    if (!team.contains(j)) {
                        reverseHap += arr[i][j];
                    }
                }
            }
        }
        // System.out.println("hap is "+hap+", reverseHap is "+reverseHap);
        hap = Math.abs(reverseHap - hap);
        ans = ans < hap ? ans : hap;
    }
}

