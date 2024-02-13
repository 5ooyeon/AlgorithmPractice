package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class AC_5430 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <= T ; tc++) {
            String func = bf.readLine();
            int size = Integer.parseInt(bf.readLine());
            Boolean isReversed = false, isError = false;
            Deque<String> deque = new LinkedList<>();
            String tempArray = bf.readLine();
            tempArray = tempArray.replace("[", "");
            tempArray = tempArray.replace("]", "");
            String[] arr = tempArray.split(",");
            for(int i=0;i<size;i++) {
                deque.offer(arr[i]);
            }
            // for(String x : deque) {
            //     System.out.println(x);
            // }
            for(int i=0;i<func.length();i++) {
                if(func.charAt(i)=='R') {
                    System.out.println(isReversed);
                    isReversed = isReversed == true ? false : true;
                } else {
                    if(deque.size()==0) {
                        sb.append("error\n"); isError = true; deque.clear(); continue;
                    } else {
                        if(isReversed) {
                            System.out.println(deque.pollLast()); size--;
                        } else {
                            System.out.println(deque.pollFirst()); size--;
                        }
                    }
                }
            }
            if(!isError) {
                sb.append("[");
                String temp = "";
                if(isReversed) {
                    for(int i=0;i<size;i++) {
                        temp += (","+deque.pollLast());
                    }
                    temp = temp.replaceFirst(",", "");
                    temp += "]\n";
                    sb.append(temp);
                } else {
                    for(int i=0;i<size;i++) {
                        temp += (","+deque.pollFirst());
                    }
                    temp = temp.replaceFirst(",", "");
                    temp += "]\n";
                    sb.append(temp);
                }

            }

        }

        System.out.println(sb.toString());
    }
}
