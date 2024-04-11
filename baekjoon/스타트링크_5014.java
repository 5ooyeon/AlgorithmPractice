package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트링크_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken()),
        b = Integer.parseInt(st.nextToken()),
        c = Integer.parseInt(st.nextToken()),
        d = Integer.parseInt(st.nextToken()),
        e = Integer.parseInt(st.nextToken());


        int cnt = 0;

        if(d == 0) {
            while(b > c) {
                b -= e;
                cnt++;
            }
            if( b == c) {
                System.out.println(cnt); return;
            } else {
                System.out.println("use the stairs");return;
            }
        }

        if(e == 0) {
            while(b < c) {
                b += d;
                cnt++;
            }
            if( b == c) {
                System.out.println(cnt); return;
            } else {
                System.out.println("use the stairs"); return;
            }
        }

        if(d == 0 && e == 0) {
            if(b == c) {
                System.out.println(0); return;
            } else {
                System.out.println("use the stairs"); return;
            }
        }

        boolean isChanged = true;
        if(b < c) {

            while(b != c) {

                isChanged = false;

                while(b < c && b+d <= a) {
                    b += d;
                    cnt++;
                    isChanged = true;
                }
                if(b == c) break;
                while(b+d > a && b - e > 0) {
                    b -= e;
                    isChanged = true;
                    cnt++;
                }
                if(!isChanged) break;
            }
        } else {
            while(b != c) {
                isChanged = false;

                while(b - e > 0 && (b > c || b+d>a) ) {
                    b -= e;
                    System.out.println(b);
                    isChanged = true;
                    cnt++;
                }
    
                if(b == c) break;
    
                while(b+d <= a && (b < c || b-e <=0)) {
                    b += d;
                    cnt++;
                    isChanged = true;
                }
                if(!isChanged) break;
            }
        }
        if(!isChanged) System.out.println("use the stairs");
        System.out.println(cnt);
    }
}
