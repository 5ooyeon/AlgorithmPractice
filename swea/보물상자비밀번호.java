package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 보물상자비밀번호 {
    static int n, k, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> set = new TreeSet<>();
        
        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <=t ;tc++) {
            sb.append("#"+tc+" ");

            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];

            int length = n/4;
            String nums = bf.readLine();
            int tt = 0;
            for(int i=n-1;i>=0;i--) {
                Character temp = nums.charAt(tt++);
                if(temp >= 65) {
                    arr[i] = temp - 55;
                } else {
                    arr[i] = temp - '0';
                }
            }

            for(int m=0;m<length;m++) {
                int idx = m;
                for(int time=0;time<4;time++) {
                    int temp = 0;
                    for(int i=0;i<length;i++) {
                        if(idx == n) {
                            idx -= n;
                        }
                        temp += Math.pow( 16, i) * arr[idx++];
                    }
                    System.out.print(temp+" ");
                    set.add(temp);
                }
            }
            int ans = 0;
            for(int i=0;i<k;i++) {
                ans = set.pollLast();
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
