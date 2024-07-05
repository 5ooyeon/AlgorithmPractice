package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 현대모비스특별상의주인공은물음표_28128 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j] = st.nextToken();
            }
        }



        ArrayList<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(isInRange(i+1, n) && arr[i][j].equals(arr[i+1][j]) && !set.contains(arr[i][j])) {
                    ans.add(arr[i][j]);
                    set.add(arr[i][j]);
                } else if(isInRange(i+2, n) && arr[i][j].equals(arr[i+2][j]) && !set.contains(arr[i][j])) {
                    ans.add(arr[i][j]);
                    set.add(arr[i][j]);
                } else if(isInRange(j+1, m) && arr[i][j].equals(arr[i][j+1]) && !set.contains(arr[i][j])) {
                    ans.add(arr[i][j]);
                    set.add(arr[i][j]);
                } else if(isInRange(j+2, m) && arr[i][j].equals(arr[i][j+2]) && !set.contains(arr[i][j])) {
                    ans.add(arr[i][j]);
                    set.add(arr[i][j]);
                }
            }
        }

        if(ans.isEmpty()) {
            System.out.println("MANIPULATED");
        } else {

            Collections.sort(ans);
            for (String an : ans) {
                System.out.println(an);
            }

        }

    }

    private static boolean isInRange(int i, int n) {
        return i>=0 && i < n;
    }
}
