package A형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 준환이의양팔저울 {
    static int n;
    static ArrayList<Integer> weight = new ArrayList<>();
    static ArrayList<Integer> left = new ArrayList<>();
    static ArrayList<Integer> right = new ArrayList<>();
    static int leftHap = 0;
    static int rightHap = 0;

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= t ; tc++) {
            n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            // weight = new ArrayList<>();

            int hap = 0;

            for(int i=0;i<n;i++) {
                int temp = Integer.parseInt(st.nextToken());
                weight.add(temp);
            }

            for(int i=0;i<n;i++) {
                bfs(i);
            }

        }
    }

    static void bfs(int idx) {
        if(leftHap >= rightHap+weight.get(idx)) {
            rightHap += weight.remove(idx);
            //오른쪽에 놨을때의 경우
            for(int i=0;i<weight.size();i++) {
                bfs(i);
            }
        }
    }
}
