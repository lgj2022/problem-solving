import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n  = Integer.parseInt(st.nextToken());
		int k  = Integer.parseInt(st.nextToken());
		int []w =new int[n+1];
		int []v = new int[n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			v[i]=Integer.parseInt(st.nextToken());
		}
		
		int dp [][] = new int[n+1][k+1];
		
		for (int i = 1; i <=n; i++) {
			//System.out.println(Arrays.toString(dp[i]));
			for (int j = 1; j <= k; j++) {
				dp[i][j]=dp[i-1][j];
				if(j-w[i]>=0) {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
				}
			}
			//System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[n][k]);
	}
}
