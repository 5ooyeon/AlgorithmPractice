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
             //메모이제이션 : 모든 추의 무게 * 선택된 추
            dp=new int [sum+1][(1<<N)]; 
             
             
            res = dfs(0,0,0,0);
            StringBuilder sb=new StringBuilder();
            sb.append("#").append(tc).append(' ').append(res).append('\n');
            System.out.print(sb.toString());
             
        }
         
    }

    /**
     * 
     * @param dep : N개 만큼 추를 올려보기
     * @param sumL : 왼쪽 저울 무게
     * @param sumR : 오른쪽 저울 무게
     * @param visit : 사용한 추 (비트 연산)
     * @return
     */
    static int dfs(int dep,int sumL, int sumR, int visit) {
        if(dep==N) //한가지 올려놓는 경우 완성!
        	return 1;
        if(dp[sumL][visit]!=0)
        	return dp[sumL][visit]; //순서만 바꿔서 같은 무게가 오면? 난 경우의 수 알고 있음
    	
        int res = 0;
    	//0~N번 추를 다 올려 놓는 시도를 매번 함.
    	for (int i = 0; i < N; i++) {
			//이미 사용했는지 확인
    		if((visit&(1<<i))!=0) continue; //이미 올려 놓은 추는 다시 올릴 수 없음 
    		
    		//왼쪽 저울에 올려놓기
    		res += dfs(dep+1, sumL+arr[i], sumR, visit|(1<<i));
    		//조건 따라서 오른쪽 저울에 올려놓기
    		if(sumL >= sumR+arr[i]) {
    			res += dfs(dep+1, sumL, sumR+arr[i], visit|(1<<i));
    		}
    	}
    	
    	//같은 무게가 왼쪽에 올려 졌을 때, 오른쪽에 올릴 수 있는 경우의 수는 같음
    	//따라서 메모해두기!!
    	return dp[sumL][visit] = res;
         
    }
}