package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class 이진탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int deptNum = 1;
        int[] putNums = new int[n+1];
        ArrayList<Integer> depts = new ArrayList<>();

        while(deptNum <= n) {
            depts.add(deptNum);
            deptNum += deptNum;
        }

        putNums[depts.get(depts.size()-1)] = 1;
        int idx = depts.get(depts.size()-1);

        //top point= n/2 + 1;


        for(int i=2;i<= n/2 +1;i++) {
            if(idx%2==0) { //왼쪽노드
                //오른쪽 자식노드에 값이 있는지 확인
                if(putNums[idx+1]==0) { //오른쪽 노드가 비어있을 때
                    putNums[idx/=2] = i; continue;
                } 딘ㄷ {
                    
                }
            }
        }

    }
}
