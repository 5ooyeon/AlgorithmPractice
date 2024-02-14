package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 이중우선순위큐_7662 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int tc=0;tc<T;tc++) {
            int n = Integer.parseInt(bf.readLine());
            PriorityQueue<Long> minPQ = new PriorityQueue<>();
            PriorityQueue<Long> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            TreeMap<Long, Integer> map = new TreeMap<>();
            
            int size = 0;

            StringTokenizer st;

            for(int c=0;c<n;c++) {
                st = new StringTokenizer(bf.readLine());
                if(st.nextToken().equals("I")) {
                    long num = Long.parseLong(st.nextToken());
                    minPQ.add(num); maxPQ.add(num);
                    int value = map.get(num) == null || map.get(num) == 0? 1 : map.get(num)+1;
                    map.put(num, value);
                    size++;
                } else {
                    String temp = st.nextToken();
                    if(size<2) {
                        minPQ.clear(); maxPQ.clear(); size = 0;
                        map.clear();
                        continue;
                    }
                    if(temp.equals("-1")) {
                        while(map.get(minPQ.peek())==0) {
                            minPQ.poll();
                        }
                        map.put(minPQ.peek(), map.get(minPQ.poll())-1);
                    } else {
                        while(map.get(maxPQ.peek())==0) {
                            maxPQ.poll();
                        }
                        map.put(maxPQ.peek(), map.get(maxPQ.poll())-1);
                    }
                    size--;
                }
            }
            if(size==0) {
                sb.append("EMPTY\n");
            } else {
                while(map.get(minPQ.peek())==0) {
                    minPQ.poll();
                }
                while(map.get(maxPQ.peek())==0) {
                    maxPQ.poll();
                }
                sb.append(Long.toString(maxPQ.poll())+" "+Long.toString(minPQ.poll())+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}

