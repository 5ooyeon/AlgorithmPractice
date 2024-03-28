package swea;

import java.io.*;
import java.util.*;

class 서로소 {

    static int n, m, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <= t ; tc++) {
            sb.append("#"+tc+" ");
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

            arr = new int[n];

            for(int i=0;i<n;i++) {
                arr[i] = i;
            }

            for(int i=0;i<m;i++) {
                st = new StringTokenizer(bf.readLine());
                String temp = st.nextToken();
                int o1 = Integer.parseInt(st.nextToken())-1, o2 =Integer.parseInt(st.nextToken())-1;
                switch (temp) {
                    case "0":
                        union(Math.max(o1, o2),Math.min(o1, o2));
                        break;
                
                    default:
                        if(find(o1) == find(o2)) {
                            sb.append(1);
                        } else {
                            sb.append(0);
                        }
                        break;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }

    static int find(int o1) {
        if(o1 == arr[o1]) {
            return o1;
        }
        return arr[o1] = find(arr[o1]);
    }
}