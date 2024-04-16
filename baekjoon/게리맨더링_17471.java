package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 게리맨더링_17471 {
    static int population[];
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        population = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int totalPop = 0, ans = 0;
        for(int i=0;i<N;i++) {
            population[i] = Integer.parseInt(st.nextToken());
            totalPop += population[i];
        }

        arr = new ArrayList[N];

        for(int i=0;i<N;i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            st.nextToken();
            while(st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i].add(temp-1);
                arr[temp-1].add(i);
            }
        }

        //연결된 노드가 없는 수가 두개 이상인지 확인
        LinkedList<Integer> ansList = new LinkedList<>();
        for(int i=0;i<N;i++) {
            if(arr[i].size()==0) {
                ansList.add(i);
            }
        }
        if(ansList.size()>=2) {
            System.out.println(-1);System.exit(0);
        }
        if(ansList.size() == 1) {
            int n = ansList.getLast();
            int a = population[n];
            int b = totalPop - population[n];
            System.out.println(Math.abs(b-a)); System.exit(0);

        }

        ansList = new LinkedList<>();
        ansList.add(0);
        dfs(ansList);
        
    }



    static void dfs(LinkedList<Integer> ansList) {



        int n = ansList.getLast();
        for(int i : arr[n]) {
            ansList.add(i);
            dfs(ansList);
            ansList.removeLast();
        }
    }

    
}
