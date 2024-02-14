package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 공통조상 {
    static HashSet<Integer> set;
    static ArrayList<Integer>[] getSubTree;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());

            int edge = Integer.parseInt(st.nextToken());
            st.nextToken();
            int p1 = Integer.parseInt(st.nextToken()), p2 = Integer.parseInt(st.nextToken());
            int ans = 0;

            getSubTree = new ArrayList[edge+1];
            int[] arr = new int[edge+1];

            for(int i=0;i<edge+1;i++) {
                getSubTree[i] = new ArrayList<>();
            }

            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<edge-1;i++) {
                int a =Integer.parseInt(st.nextToken()), b= Integer.parseInt(st.nextToken());
                arr[b] = a;
                getSubTree[a].add(b);
            }

            ArrayList<Integer> pp1 = new ArrayList<>();
            ArrayList<Integer> pp2 = new ArrayList<>();

            while(p1 != 1) {
                int temp = arr[p1];
                pp1.add(temp);
                p1 = temp;
            }
            while(p2 != 1) {
                int temp = arr[p2];
                pp2.add(temp);
                p2 = temp;
            }

            ArrayList<Integer> sht =  pp1.size() < pp2.size() ? pp1 : pp2;
            ArrayList<Integer> lng = sht.equals(pp1) ? pp2 : pp1;
            set = new HashSet<>(lng);

            for(int i=0;i<sht.size();i++) {
                int a = set.size();
                set.add(sht.get(i));
                if(a == set.size() ) {
                    ans = sht.get(i); break;
                }
            }
            sb.append("#"+tc+" "+ans);
            set.clear();
            getSubTreeSize(ans);
            sb.append(" "+set.size()+"\n");
        }
        System.out.println(sb.toString());
    }
    static void getSubTreeSize(int top) {
        set.add(top);
        if(getSubTree[top].size() != 0) {
            for(int x : getSubTree[top]) {
                getSubTreeSize(x);
            }
        }
    }
}
