package baekjoon.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 작업_2056 {
    static ArrayList<Integer>[] list;
    static int times[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        list = new ArrayList[N];
        times = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            times[i] = time;
            list[i] = new ArrayList<>();

            for(int j=0;j<size;j++) {
                list[i].add(Integer.parseInt(st.nextToken())-1);
            }
        }
    }
}
