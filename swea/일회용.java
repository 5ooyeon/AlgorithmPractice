package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 일회용 {
    static int max, min;
    static LinkedList<Integer> list;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        for(int tc = 1 ; tc <= t; tc++) {
            sb.append("#"+tc+" ");
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken()); min = Integer.parseInt(st.nextToken()); max = Integer.parseInt(st.nextToken());
            ans = -1;
            list = new LinkedList<>();

            st = new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens()) {
                list.offer(Integer.parseInt(st.nextToken()));
            }

            if(min*3 > n || max*3 < n ) {
                sb.append("-1\n"); continue;
            }

            Collections.sort(list);
            getBan(new ArrayList<>());
            sb.append(ans+"\n");;

        }
        System.out.println(sb.toString());
    }
    static void getBan(ArrayList<Integer> arr) {
        if(arr.size()==2) {
            int c = (list.size()-arr.get(0)-arr.get(1)), a = arr.get(0), b = arr.get(1);
            int largest = Math.max(Math.max(a, b), c);
            int smallest = Math.min(Math.min(a, b), c);

            if(ans == -1) {
                ans = largest-smallest;
            } else {
                ans = ans < largest - smallest ? ans : largest - smallest;
            }
            return;
        }

        if(arr.size()==1) {
            int idx = arr.get(0);
            int cnt =0;
            for(int i=idx;i<list.size()-min;i++) {
                cnt++;
                if(cnt >= min && list.get(i+1)!= list.get(i)) {
                    arr.add(cnt);
                    getBan(arr);
                    arr.remove(1);
                }
                if(cnt==max) {
                    cnt = 0;
                }
            }
        }

        if(arr.size()==0) {
            int cnt =0;
            for(int i=0;i<list.size()-min*2;i++) {
                cnt++;
                if(cnt >= min && list.get(i+1)!= list.get(i)) {
                    arr.add(cnt);
                    getBan(arr);
                    arr.remove(0);
                }
                if(cnt==max) {
                    cnt = 0;
                }
            }
        }
    }
}
