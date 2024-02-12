package baekjoon;

import java.io.*;
import java.util.*;
public class 탑_2493 {
    static int[] ans;
    static int N;
    static PriorityQueue<int[]> dummy;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        ans = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        dummy = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
            
        });

        while(st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        compareNum(N-1);
        for(int i : ans) {
            bw.write(i+" ");
        }
        bw.flush();
    }

    private static void compareNum(int idx) {
        if(idx == -1) {
            return;
        }
        if(!dummy.isEmpty()) {
            while(!dummy.isEmpty() && dummy.peek()[1] < arr.get(idx)) {
                ans[dummy.poll()[0]] = idx+1;
            }
        }
        int[] temp = new int[2];
        temp[0] = idx; temp[1] = arr.get(idx);
        dummy.add(temp);
        compareNum(--idx);
    }
}
