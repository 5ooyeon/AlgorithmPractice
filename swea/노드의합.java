package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 노드의합 {
    static int[] nodes;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc = 1;tc <=T;tc++) {
            st = new StringTokenizer(bf.readLine());
            int node = Integer.parseInt(st.nextToken());
            nodes = new int[node+1];
            int cases = Integer.parseInt(st.nextToken()), point = Integer.parseInt(st.nextToken());
            for(int i=0;i<cases;i++) {
                st = new StringTokenizer(bf.readLine());
                nodes[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            getSum(point);
            sb.append("#"+tc+" "+nodes[point]+"\n");
        }
        System.out.println(sb.toString());
    }
    private static int getSum(int point) {
        if(point < nodes.length) {
            if(nodes[point]!=0) {
                return nodes[point];
            }
            return nodes[point] = getSum(point*2) + getSum(point*2+1);
        }
        return 0;
    }
}
