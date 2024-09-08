package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NBA농구_2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int team1 = 0, team2 = 0;

        StringTokenizer st = null;
        int team1Time = -1, team2Time = -1;
        int team1Score = 0, team2Score = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            String team = st.nextToken();

            if(team1Time != -1) {
                if (team.equals("1")) {
                    team1Score++;
                } else {
                    team2Score++;
                    if(team1Score==team2Score) {
                        String[] time = st.nextToken().split(":");
                        int nowTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                        team1 += nowTime - team1Time;
                        team1Time = -1;
                    }
                }
            } else if(team2Time != -1) {
                if (team.equals("1")) {
                    team1Score++;
                    if(team1Score==team2Score) {
                        String[] time = st.nextToken().split(":");
                        int nowTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                        team2 += nowTime - team2Time;
                        team2Time = -1;
                    }
                } else {
                    team2Score++;
                }
            } else {
                if (team.equals("1")) {
                    team1Score++;
                    String[] time = st.nextToken().split(":");
                    int nowTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                    team1Time = nowTime;
                } else {
                    team2Score++;
                    String[] time = st.nextToken().split(":");
                    int nowTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                    team2Time = nowTime;
                }
            }
        }
        if(team2Score > team1Score) {
            team2 += 48 * 60 - team2Time;
        } else if(team2Score < team1Score) {
            team1 += 48 * 60 - team1Time;
        }
        if(team1!=0) {
            int hour = team1/60;
            int minute = team1%60;
            System.out.print(hour < 10 ? "0"+hour : hour);
            System.out.print(":");
            System.out.println(minute < 10 ? "0"+minute : minute);
        } else {
            System.out.println("00:00");
        }
        if(team2!=0) {
            int hour = team2/60;
            int minute = team2%60;
            System.out.print(hour < 10 ? "0"+hour : hour);
            System.out.print(":");
            System.out.print(minute < 10 ? "0"+minute : minute);
        } else {
            System.out.println("00:00");
        }
    }
}
