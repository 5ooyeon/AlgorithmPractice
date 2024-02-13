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
            PriorityQueue<Long> minPQ = new PriorityQueue<>();
            PriorityQueue<Long> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Long> erasedMaxQueue = new PriorityQueue<>(); //maxPQ에서 지운 값 넣기
            PriorityQueue<Long> erasedMinQueue = new PriorityQueue<>(Collections.reverseOrder()); //minPQ에서 지운 값 넣기
            
            StringTokenizer st;
            for(int c=0;c<n;c++) {
                st = new StringTokenizer(bf.readLine());
                if(st.nextToken().equals("I")) {
                    long num = Long.parseLong(st.nextToken());
                    minPQ.add(num); maxPQ.add(num);
                } else {
                    String temp = st.nextToken();
                    if(temp.equals("-1") && minPQ.size()!=0) { //min값 삭제
                        long num = minPQ.poll();
                        erasedMinQueue.add(num); //삭제된 min값에 넣기


                    } else if(temp.equals("1") && maxPQ.size()!=0) { //max값 삭제
                        long num = maxPQ.poll();
                        erasedMaxQueue.add(num); //삭제된 max값에 넣기


                    }

                    //queue 크기 확인, 지웠던 max값들 중 min값과 minPQ의 min값이 같다면 poll
                    while(erasedMaxQueue.size()!=0 && minPQ.size()!=0 && erasedMaxQueue.peek()==minPQ.peek()) {
                        erasedMaxQueue.poll(); minPQ.poll();
                    }
                    //queue 크기 확인, 지웠던 max값들 중 min값과 minPQ의 min값이 같다면 poll
                    while(erasedMinQueue.size()!=0 && maxPQ.size()!=0 && erasedMinQueue.peek()==maxPQ.peek()) {
                        erasedMinQueue.poll(); maxPQ.poll();
                    }
                }

                /**
                System.out.print("maxPQ: ");
                for(long x : maxPQ) {
                    System.out.print(x+" ");
                }
                System.out.print("\nminPQ: ");
                for(long x : minPQ) {
                    System.out.print(x+" ");
                }
                System.out.print("\nsize: "+erasedMaxQueue.size()+", erasedMaxQueue :");
                for(long x : erasedMaxQueue) {
                    System.out.print(x+" ");
                }
                System.out.print("\nsize: "+erasedMinQueue.size()+", erasedMinQueue :");
                for(long x : erasedMinQueue) {
                    System.out.println(x+" ");
                }
                System.out.println();
                **/


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

