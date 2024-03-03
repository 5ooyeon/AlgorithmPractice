package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게리맨더링_17471 {
    static int population[];
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        population = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        arr = new ArrayList[N];

        for(int i=0;i<N;i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            st.nextToken();
            while(st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken())
                arr[i].add(temp-1);
                arr[temp-1].add(i);
            }
        }

        int cntZero = 0;
        for(int i=0;i<N;i++) {
            if(arr[i].size()==0) {
                cntZero++;
            }
        }
        
    }

    
}
