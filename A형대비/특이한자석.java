package A형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 특이한자석 {
    static LinkedList<String>[] topnis;
    static Boolean movingLeft = true;
    static int target= 0;
    static int[] canMove;
    //isMoved[target][0] 에는 회전 여부

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc <=T; tc++) {
            topnis =new LinkedList[4];
            StringTokenizer st;

            int t = Integer.parseInt(bf.readLine());

            for(int i=0;i<4;i++) {
                topnis[i] = new LinkedList<>();
                st = new StringTokenizer(bf.readLine());
                for(int j=0;j<8;j++) {
                    topnis[i].add(st.nextToken());
                }
            }
    
            for(int i=0;i<t;i++) {
                st = new StringTokenizer(bf.readLine());
                target = Integer.parseInt(st.nextToken())-1;
                movingLeft = st.nextToken().equals("1") ? false : true;
    
                canMove = new int[4];
    
                canMove[target] = 1;
                int temp = target;
    
                while(temp >= 1) {
                    if(topnis[temp-1].get(2).equals(topnis[temp].get(6))) {
                        canMove[temp-1] = 0; break;
                    } else {
                        canMove[temp-1] = 1; temp -= 1;
                    }
                }
                temp = target;
                while(temp < 3) {
                    if(topnis[temp+1].get(6).equals(topnis[temp].get(2))) {
                        canMove[temp+1] = 0; break;
                    } else {
                        canMove[temp+1] = 1; temp += 1;
                    }
                }
    
                for(int m=0;m<4;m++) {
                    if(m==0) {
                        
                        if(!movingLeft) {
                            topnis[target].addFirst(topnis[target].removeLast());
                        } else {
                            topnis[target].add(topnis[target].removeFirst());
                        }
                        movingLeft = movingLeft == true ? false : true;
                        continue;
    
                    }
                    if(target-m>=0 && canMove[target-m]==1) {
                        if(!movingLeft) {
                            topnis[target-m].addFirst(topnis[target-m].removeLast());
                        } else {
                            topnis[target-m].add(topnis[target-m].removeFirst());
                        }
                    }
                    if(target+m<4 && canMove[target+m]==1) {
                        if(!movingLeft) {
                            topnis[target+m].addFirst(topnis[target+m].removeLast());
                        } else {
                            topnis[target+m].add(topnis[target+m].removeFirst());
                        }
                    }
                    movingLeft = movingLeft == true ? false : true;
                }
    
            }
            int ans = 0;
            if(topnis[0].get(0).equals("1")) {
                ans += 1;
            }
            if(topnis[1].get(0).equals("1")) {
                ans += 2;
            }
            if(topnis[2].get(0).equals("1")) {
                ans += 4;
            }
            if(topnis[3].get(0).equals("1")) {
                ans += 8;
            }

            sb.append("#"+tc+" "+ans+"\n");
        }

        System.out.println(sb.toString());
    }

}
