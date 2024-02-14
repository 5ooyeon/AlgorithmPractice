package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중위순회 {
    static String[] inputs;
    static String[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 1; tc <=10;tc++) {
            int N = Integer.parseInt(bf.readLine());
            inputs = new String[N+1];
            ans = new String[N+1];

            for(int i=0;i<N;i++) {
                String input = bf.readLine();
                String[] temp = input.split(" ");

                inputs[Integer.parseInt(temp[0])] = input;
                ans[Integer.parseInt(temp[0])] = temp[1];
            }
            sb.append("#").append(tc).append(" ");
            getWord(1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void getWord(int num) {
        String input = inputs[num];
        String[] temp = input.split(" ");
        if(temp.length>3) {
            getWord(Integer.parseInt(temp[2]));
            sb.append(ans[num]);
            getWord(Integer.parseInt(temp[3]));
        } else if(temp.length==3) {
            getWord(Integer.parseInt(temp[2]));
            sb.append(ans[num]);
        } else {
            sb.append(ans[num]); return;
        }
    }
}
