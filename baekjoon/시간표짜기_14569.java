package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시간표짜기_14569 {
    static int classes[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        classes = new int[N][5];
        
        StringTokenizer st = null;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken()); //과목 시간 수

            //남은 st에서 과목 시간 받기
            for(int j=0;j<k;j++) {
                int a = Integer.parseInt(st.nextToken());
                classes[i][a == 1 ? 0 : (a-1)/10] |= 1 << (a == 1 ? 0 : (a-1)%10);
            }
        }
        int M = Integer.parseInt(bf.readLine()); //학생 수
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken()); //비어있는 교시 개수
            
            int[] tg = new int[5];

            for(int j=0;j<p;j++) {
                int temp = Integer.parseInt(st.nextToken());
                tg[temp == 1 ? 0 : (temp-1)/10] |= 1 << (temp == 1 ? 0 : (temp-1)%10);
            }

            int ans = 0;

            start : for(int j=0;j<N;j++) {
                for(int k=0;k<5;k++) {

                    // System.out.println(tg[k]);
                    // System.out.println(classes[j][k]);

                    // System.out.println(tg[k] & classes[j][k]);
                    if(((tg[k] & classes[j][k]) != classes[j][k])) {
                        continue start;
                    }
                    // System.out.println(tg[i] | classes[j][i]);
                }
                ans++;
            }

            //교시 시간
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
