package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class 거짓말_1043 {

    static int truth[], ans[], partyCheck[];
    static HashSet<Integer>[] party;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        st= new StringTokenizer(bf.readLine());
        ans = new int[m];
        party = new HashSet[n];
        partyCheck = new int[n];
        truth = new int[Integer.parseInt(st.nextToken())];

        for(int i=0;i<truth.length;i++) {
            truth[i] = Integer.parseInt(st.nextToken())-1;
        }

        list = new ArrayList[m];
        for(int i=0;i<m;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int size = Integer.parseInt(st.nextToken());
            party[i] = new HashSet<>();

            Queue<Integer> q = new ArrayDeque<>();
            while(st.hasMoreTokens()) {
                q.offer(Integer.parseInt(st.nextToken())-1);
            }
            for(int j=0;j<size-1;j++) {
                int a = q.poll(), b = q.peek();
                party[i].add(a);
                list[a].add(b);
                list[b].add(a);
            }
            party[i].add(q.poll());
        }

        for(int i=0;i<truth.length;i++) {
            int target = truth[i];
            dfs(target);
        }

        int ansCnt = 0;

        for(int i=0;i<m;i++) {
            if(ans[i] == 1) {
                for(int j=0;j<n;j++) {
                    if(party[j].contains(ans[i])) {
                        partyCheck[j] = 1;
                    }
                }
            }
        }

        for(int i=0;i<n;i++) {
            if(partyCheck[i]==0) {
                ansCnt++;
            }
        }

        System.out.println(ansCnt);

    }

    static void dfs(int target) {
        ans[target] = 1;
        for(int a : list[target]) {
            if(a != target) {
                dfs(a);
            }
        }
    }
}
