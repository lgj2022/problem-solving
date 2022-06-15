import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int r;
	static int c;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		 r = Integer.parseInt(st.nextToken());
		 c = Integer.parseInt(st.nextToken());
		
		map= new int [r][c];
		for (int i = 0; i < r; i++) {
			String s = bf.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		
		
		//printmap();
		int visit[][]= new int [r][c];
		dfs(0,visit);
		System.out.println(ans);
	}
	private static void dfs(int idx, int[][] visit) {
		// TODO Auto-generated method stub
		if(idx==r*c) {
			int sum = check(visit);
			ans=Math.max(ans, sum);
			return;
		}
		int a = idx/c;
		int b = idx%c;
		visit[a][b]=1;
		dfs(idx+1,visit);
		visit[a][b]=0;
		dfs(idx+1,visit);
	}
	private static int check(int[][] visit) {
		int sum = 0;
		for (int i = 0; i < visit.length; i++) {
			int rowsum =0;
			int count = 1;
			for (int j = visit[0].length-1; j >=0 ; j--) {
				if(visit[i][j]==1) {
					rowsum+=map[i][j]*count;
					count=count*10;
				}
				else {
					count =1;
				}
			}
			sum+=rowsum;
		}
		
		for (int i = 0; i < visit[0].length; i++) {
			int colsum =0;
			int count = 1;
			for (int j = visit.length-1; j >=0 ; j--) {
				if(visit[j][i]==0) {
					colsum+=map[j][i]*count;
					count=count*10;
				}
				else {
					count =1;
				}
			}
			sum+=colsum;
		}
		
		return sum;
	}
	static void printmap() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
