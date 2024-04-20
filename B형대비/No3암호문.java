package B형대비;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No3암호문 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = 0;
        while(tc++ <= 10) {
            bw.write("#"+Integer.toString(tc)+" ");
            int N = Integer.parseInt(bf.readLine());
            LinkedList<String> list = new LinkedList<>();

            st = new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            int M = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens()) {
                String order = st.nextToken();
                switch (order) {
                    case "I":
                        int x = Integer.parseInt(st.nextToken()),
                        y = Integer.parseInt(st.nextToken());
                        LinkedList<String> tempList = new LinkedList<>();
                        for(int i=0;i<y;i++) {
                            tempList.add(st.nextToken());
                        }
                        list.addAll(x, tempList);
                        break;                    
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for(int i=0;i<y;i++) {
                            list.remove(x);
                        }
                        break;                    
                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        for(int i=0;i<y;i++) {
                            list.add(st.nextToken());
                        }
                        break;
                
                    default:
                        break;
                }
            }
            for(int i=0;i<10;i++) {
                bw.write(list.removeFirst()+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
