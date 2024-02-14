package baekjoon;

/**
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AC_5430 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <= T ; tc++) {
            String func = bf.readLine();
            int size = Integer.parseInt(bf.readLine());
            Boolean isReversed = false, isError = false;
            ArrayList<String> arr =new ArrayList<>();
            String temp = bf.readLine();
            StringTokenizer st = new StringTokenizer(temp, ",");

            int cnt = 0;

            for(int i=0;i<size;i++) {
                String t = st.nextToken();
                if(t.contains("[")) {
                    t = t.replace("[", "");
                }
                if(t.contains("]")) {
                    t = t.replace("]", "");
                }
                arr.add(t);
            }


            for(int i=0;i<func.length();i++) {
                if(func.charAt(i) == 'D') {
                    cnt ++;
                }
            }

            if(cnt > size) {
                sb.append("error\n");continue;
            }

            int p1 = 0, p2 = arr.size()-1;

            for(int c = 0; c < func.length();c++) {
                if(func.charAt(c)=='R') {
                    isReversed = isReversed == true ? false : true;
                } else {
                    if(isReversed) {
                        p2--;
                    } else {
                        p1++;
                    }

                    if(p2 <= p1) {
                        isError = true; break;
                    }
                }
            }
            if(isError) {
                sb.append("error\n");
            } else {
                if(isReversed) {
                    sb.append("["+arr.get(p2));
                    for(int i=p2-1;i>=p1;i--) {
                        sb.append(","+arr.get(i));
                    }
                    sb.append("]\n");
                } else {
                    sb.append("["+arr.get(p1));
                    for(int i=p1+1; i <= p2;i++) {
                        sb.append(","+arr.get(i));
                    }
                    sb.append("]\n");
                }
            }

        }

        System.out.println(sb.toString());
    }
}

**/


import java.io.*;
import java.util.*;

public class AC_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <= T ; tc++) {
            String func = bf.readLine();
            int size = Integer.parseInt(bf.readLine());
            Boolean isReversed = false, isError = false;
            Deque<String> deque = new LinkedList<>();
            String getInput = bf.readLine();
            StringTokenizer st = new StringTokenizer(getInput, ",");

            int cnt = 0;

            for(int i=0;i<size;i++) {
                String t = st.nextToken();
                if(t.contains("[")) {
                    t = t.replace("[", "");
                }
                if(t.contains("]")) {
                    t = t.replace("]", "");
                }
                deque.offer(t);
            }

            for(int i=0;i<func.length();i++) {
                if(func.charAt(i) == 'D') {
                    cnt ++;
                }
            }

            if(cnt > size) {
                sb.append("error\n");continue;
            }

            for(int i=0;i<func.length();i++) {
                if(func.charAt(i)=='R') {
                    isReversed = isReversed == true ? false : true;
                } else {
                    if(deque.size()==0) {
                        sb.append("error\n"); isError = true; deque.clear(); break;
                    } else {
                        if(isReversed) {
                            deque.pollLast(); size--;
                        } else {
                            deque.pollFirst(); size--;
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