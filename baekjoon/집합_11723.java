package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 집합_11723
 */
public class 집합_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            switch (st.nextToken()) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    if(set.contains(Integer.parseInt(st.nextToken()))) {
                        sb.append(1+"\n");
                    } else {
                        sb.append(0+"\n");
                    }
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "toggle":
                    int temp = Integer.parseInt(st.nextToken());
                    if(set.contains(temp)) {
                        set.remove(temp);
                    } else {
                        set.add(temp);
                    }
                    break;
                case "all":
                    for(int num=1;num<=20;num++) {
                        set.add(num);
                    }
                    break;
                default:
                    set.clear();
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}