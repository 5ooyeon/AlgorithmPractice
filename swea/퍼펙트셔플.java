package swea;

import java.io.*;

public class 퍼펙트셔플 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        
        for(int tc = 1; tc <= N ; tc++) {
            int wordLength = Integer.parseInt(bf.readLine());
            int stNum = wordLength%2==0 ? wordLength/2 : wordLength/2+1;
            String[] temp = bf.readLine().split(" ");

            System.out.print("#"+tc+" ");
            
            for(int i=0;i<wordLength;i++) {
                if(i%2==0) {
                    System.out.print(temp[i/2]+" ");
                } else {
                    System.out.print(temp[i/2+stNum]+" ");
                }
            }
            System.out.println();
        }
    }
}
