package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class 이중우선순위큐_7662 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int tc=0;tc<T;tc++) {
            int n = Integer.parseInt(bf.readLine());
            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> erasedMaxQueue = new PriorityQueue<>();
            
            StringTokenizer st;
            for(int c=0;c<n;c++) {
                st = new StringTokenizer(bf.readLine());
                if(st.nextToken().equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    minPQ.add(num); maxPQ.add(num);
                } else {
                    String temp = st.nextToken();
                    if(temp.equals("-1") && minPQ.size()!=0) {
                        int num = minPQ.poll();
                        set.add(num);
                    } else if(temp.equals("1") && maxPQ.size()!=0) {
                        int num = maxPQ.poll();
                        set.add(num);
                    }
                }

                if(minPQ.isEmpty() || maxPQ.isEmpty()) {
                    minPQ.clear(); maxPQ.clear();
                }
            }
            if(minPQ.size()==0) {
                sb.append("EMPTY\n");
            } else {
                sb.append(Integer.toString(maxPQ.poll())+" "+Integer.toString(minPQ.poll())+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
