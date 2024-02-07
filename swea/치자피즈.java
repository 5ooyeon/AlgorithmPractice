package swea;

import java.util.HashSet;
import java.util.*;

public class 치자피즈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();

        for(int tc = 1; tc <= N ; tc++) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] chizza = new int[n][2]; //화덕
            int[] peeze = new int[m]; //피자

            for(int i=0;i<m;i++) {
                set.add(i);
                peeze[i] = sc.nextInt();
            }

            for(int i= 0; i <n ;i++) { //화덕에 피자 넣기
                chizza[i][0] = i;
                chizza[i][1] = peeze[i];
            }

            int pointer = n-1; //현재 들어가있는

            // Boolean getOut = false;
            while(set.size()!=1) {
                for(int i=0;i<n;i++) {
                    chizza[i][1] /= 2;
                    if(chizza[i][1] == 0) {
                        set.remove(chizza[i][0]);
                        if(set.size()==1) { //남은 피자 수가 하나라면 종료
                            break;
                        }
                        if(pointer<m-1) {
                            chizza[i][0] = ++pointer; //피자 인덱스 저장
                            chizza[i][1] = peeze[pointer]; //피자 치즈 저장
                        }
                    }
                }
            }

            Iterator<Integer> itr = set.iterator();
            System.out.println("#"+tc+" "+(itr.next()+1));

        }
    }

}
