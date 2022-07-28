
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Main {
 
    static BufferedReader br;
 
    public static void main(String[] args) throws Exception {
 
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[][] dp = new int[N+1][2];
 
        for (int i = 0; i <N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //dp[N][0] 은 한번에 한칸 올랐을 때
        //dp[N][1] 은 한번에 두칸 올랐을 때
        dp[0][0] = arr[0];
        dp[1][0] = dp[0][0]+ arr[1];
        dp[1][1] = arr[1];
        
        for(int i=2; i<N; i++){
            //이전에 두칸 올랐을때만 현재 한칸을 이동할 수 있다.
            //이전에 한칸 올랐다면 연속된 세칸을 밟을 경우가 생긴다.
            dp[i][0] = dp[i-1][1] + arr[i];
            
            //두칸을 이동할 경우 어떠한 제한조건이 없다. 두칸전 위치의 최대값과 현재값을 더해준다.
            dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1])+arr[i];
        }
        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
        
        
    }
}
