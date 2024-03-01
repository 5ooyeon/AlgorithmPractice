package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 패션왕신해빈_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int tc = 0; tc<t; tc++) {
            int n = Integer.parseInt(bf.readLine());
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            StringTokenizer st;
            for(int i=0;i<n;i++) {
                st = new StringTokenizer(bf.readLine());
                String a = st.nextToken(), b = st.nextToken();
                if(map.containsKey(b)) {
                    map.get(b).add(a);
                } else {
                    ArrayList<String> newArr = new ArrayList<>();
                    newArr.add(a);
                    map.put(b, newArr);
                }
            }
            Set<String> set = map.keySet();
            
        }
    }
}
