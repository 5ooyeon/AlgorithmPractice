package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 행운의바퀴_2840 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()), time = Integer.parseInt(st.nextToken());
        ArrayList<String> wheelLetter = new ArrayList<>();

        String[] arr = new String[N];
        int currIdx = 0;
        for(int t = 0 ; t < time ; t++) {
            st = new StringTokenizer(bf.readLine());
            currIdx = (currIdx + Integer.parseInt(st.nextToken()))%N;
            String letter = st.nextToken();

            if(wheelLetter.contains(letter)) {
                if(arr[currIdx] != null && arr[currIdx].equals(letter)) {
                    continue;
                } else {
                    System.out.println("!");System.exit(0);
                }
            } else if(arr[currIdx]==null) {
                arr[currIdx] = letter;
                wheelLetter.add(letter);
            } else {
                System.out.println("!");System.exit(0);
            }
        }

        for(int i=0;i<N;i++) {
            if(currIdx<0) {
                currIdx += N;
            }
            if(arr[currIdx]==null) {
                sb.append("?");
            } else {
                sb.append(arr[currIdx]);
            }
            currIdx--;
        }
        System.out.println(sb.toString());
    }
}
