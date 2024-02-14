package baekjoon;

import java.io.*;
import java.util.*;

public class 이중큐 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int tc=0;tc<T;tc++) {
            int n = Integer.parseInt(bf.readLine());
            PriorityQueue<Long> minPQ = new PriorityQueue<>();
            PriorityQueue<Long> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Long> erasedMaxQueue = new PriorityQueue<>();
            PriorityQueue<Long> erasedMinQueue = new PriorityQueue<>(Collections.reverseOrder());
            
            StringTokenizer st;
            for(int c=0;c<n;c++) {
                st = new StringTokenizer(bf.readLine());
                if(st.nextToken().equals("I")) {
                    long num = Long.parseLong(st.nextToken());
                    minPQ.add(num); maxPQ.add(num);
                } else {
                    String temp = st.nextToken();
                    if(temp.equals("-1") && minPQ.size()!=0) {
                        long num = minPQ.poll();
                        erasedMinQueue.add(num);


                    } else if(temp.equals("1") && maxPQ.size()!=0) {
                        long num = maxPQ.poll();
                        erasedMaxQueue.add(num);


                    }

                    while(erasedMaxQueue.size()!=0 && minPQ.size()!=0 && erasedMaxQueue.peek()==minPQ.peek()) {
                        erasedMaxQueue.poll(); minPQ.poll();
                    }
                    while(erasedMinQueue.size()!=0 && maxPQ.size()!=0 && erasedMinQueue.peek()==maxPQ.peek()) {
                        erasedMinQueue.poll(); maxPQ.poll();
                    }
                }
            }
            if(minPQ.size()==0 || maxPQ.size()==0) {
                sb.append("EMPTY\n");
            } else {
                sb.append(Long.toString(maxPQ.poll())+" "+Long.toString(minPQ.poll())+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}