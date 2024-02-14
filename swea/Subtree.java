package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Subtree {
    static ArrayList<Integer>[] putChild;
    static Set<Integer> set;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());
            int node = Integer.parseInt(st.nextToken()), num = Integer.parseInt(st.nextToken());

            putChild = new ArrayList[node+2];
            set = new HashSet<>();
            for(int i=0;i<putChild.length;i++) {
                putChild[i] = new ArrayList<>();
            }

            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<node;i++) {
                putChild[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }

            addSet(num);
            sb.append("#"+tc+" "+set.size()+"\n");
        }
        System.out.println(sb.toString());
    }
    private static void addSet(int num) {
        set.add(num);
        if(putChild[num].size()!=0) {
            for(int x : putChild[num]) {
                addSet(x);
            }
        }
    }
}
