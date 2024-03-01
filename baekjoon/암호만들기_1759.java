package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 암호만들기_1759 {
    static int m, n;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken()); n = Integer.parseInt(st.nextToken());
        arr = new char[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        //-
        Arrays.sort(arr);
        LinkedList<Character> ansList = new LinkedList<>();
        dfs(ansList, 0, 0);
        bw.write(sb.toString());
        bw.flush();
    }



    static void dfs(LinkedList<Character> ansList, int vowelCnt, int lastIdx) {
        if(ansList.size()== m) {
            if(vowelCnt >= 1 && m - vowelCnt >= 2) {
                for(char a : ansList) {
                    sb.append(a);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=lastIdx;i<n;i++) {
            ansList.add(arr[i]);
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                dfs(ansList, vowelCnt+1, i+1);
            } else {
                dfs(ansList, vowelCnt, i+1);
            }
            ansList.removeLast();
        }
    }
}
