package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 되돌리기_1360 {

    static ArrayList<Pair> list = new ArrayList<>();

    static class Pair {
        int first;
        String second;
        public Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        list.add(new Pair(0, ""));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            String prompt = st.nextToken();

            if (prompt.equals("type")) {
                String character = st.nextToken();
                int time = Integer.parseInt(st.nextToken());
                list.add(new Pair(time, list.get(list.size()-1).second + character));
            } else {
                int undo = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                list.add(new Pair(time, getStr(time-undo)));
            }
        }
        System.out.println(list.get(list.size()-1).second);

    }

    static String getStr(int second) {
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).first < second) {
                return list.get(i).second;
            }
        }
        return "";
    }
}