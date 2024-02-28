package swea;

import java.io.*;
import java.util.*;

public class 요리사 {
    static int n, arr[][], ans;
    static HashSet<Integer> team;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <= t; tc++) {
            sb.append("#"+tc+" ");
            n = Integer.parseInt(bf.readLine());
            arr = new int[n][n];
            team = new HashSet();
            StringTokenizer st;
            ans = Integer.MAX_VALUE;

            for(int i=0;i<n;i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken()); //재료 받아주기
                }
            }

            team.add(0); // 0번 index는 무조건 팀에 넣기
            getSet(0); 
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
    static void getSet(int idx) {
        if(team.size()==n/2) { //Set에 절반만큼 들어갔다면
            //여기서 부분집합 두개씩 고르는 함수 실행
            getTwo(team);
            return;
        }

        for(int i=idx+1;i<n;i++) {
            team.add(i);
            getSet(i);
            team.remove(i);
        }
    }

    static void getTwo(HashSet<Integer> team) {
        // System.out.println("team has "+team.toString());
        int hap = 0, reverseHap = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(team.contains(i) && team.contains(j)) { //Set에 들어있는 값일때
                    hap += arr[i][j];
                } else if(!team.contains(i) && !team.contains(j)) { //Set에 들어있지 않은 값일때
                    reverseHap += arr[i][j];
                }
            }
        }
        // System.out.println("hap is "+hap+", reverseHap is "+reverseHap);
        hap = Math.abs(reverseHap-hap);
        ans = ans < hap ? ans : hap; 
    }

}
