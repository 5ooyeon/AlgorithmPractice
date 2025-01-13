package A형보충;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울2 {
    static int N,res;
    static int arr[],dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T=Integer.parseInt(in.readLine());
        for(int tc=1;tc<=T;tc++) {
             
            N=Integer.parseInt(in.readLine()); 
            arr=new int [N]; 
            st=new StringTokenizer(in.readLine());
            int sum=0;
            for(int i=0;i<N;i++) {
                arr[i]=Integer.parseInt(st.nextToken()); 
                sum+=arr[i];//모든 추의 무게 더하기
            }
             //메모이제이션: 모든 추의 무게 * 선택된 추
             //dp = new int[추로 만들 수 있는 무게(1,2,4가 있으면 0부터 7까지)][선택된 추를 저장]
            dp=new int [sum+1][(1<<N)]; 
             
             
            res = dfs(0,0,0,0);
            StringBuilder sb=new StringBuilder();
            sb.append("#").append(tc).append(' ').append(res).append('\n');
            System.out.print(sb.toString());
             
        }
         
    }

    /**
     * 
     * @param dep : N개 만큼 추를 올려보기 (몇번째 추를 올리고 있는지)
     * @param sumL : 왼쪽 저울 무게
     * @param sumR : 오른쪽 저울 무게
     * @param visit : 사용한 추 (비트 연산)
     * @return
     */
    static int dfs(int dep,int sumL, int sumR, int visit) {
        if(dep==N) {
            return 1;
        }
        
        if(dp[sumL][visit]!=0) { //순서만 바꿔서 같은 무게라면 메모이제이션 해놨던거 호출
            return dp[sumL][visit];
        }

        int res = 0;
        //0~N번 추를 다 올려 놓는 시도를 매번 함
        for(int i=0;i<arr.length;i++) {
            //이미 사용했는지 확인
            if((visit & (1 << i))!= 0) { //이미 올려놓은 경우
                continue;
            }

            //왼쪽이면 그냥올리기
            res += dfs(dep+1,sumL+arr[i], sumR, visit |(1 << i));

            //오른쪽이면 조건 따라서
            if(sumR+arr[i] <= sumL) {
                res += dfs(dep+1,sumL, sumR+arr[i], visit |(1 << i));
            }
        }

        //같은 무게가 왼쪽에 올려졌을 때, 오른쪽에 올릴 수 있는 경우의 수는 같음.
        return dp[sumL][visit] = res;
         
    }
}