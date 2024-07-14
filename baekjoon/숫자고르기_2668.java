package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 숫자고르기_2668
 */
public class 숫자고르기_2668 {
    static int N, arr[], cnt[];
    static HashSet<Integer> ansSet = new HashSet<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(bf.readLine())-1;
            if(i == arr[i]) ansSet.add(i);
        }

        

        for(int i=0;i<N;i++) {
            cnt = new int[N];
            if(arr[i] != i) dfs(i);
            
            for(int j=0;j<N;j++) {
                if(cnt[j] == 2) ansSet.add(j);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(ansSet);
        Collections.sort(ans);

        System.out.println(ans.size());
        for(int i : ans) {
            System.out.println(i+1);
        }

    }

    static void dfs(int i) {
        if(cnt[i] >= 2 || i == arr[i]) return;

        cnt[i]++;
        dfs(arr[i]);
        
    }
}