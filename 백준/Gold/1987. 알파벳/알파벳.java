import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int r, c;
	static char[][] map;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			String s = bf.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j]=s.charAt(j);
			}
		}
		ans=1;
		boolean[] visit= new boolean[26];
		visit[map[0][0]-'A']=true;
		dfs(0,0,visit,1);
		System.out.println(ans);
	}
	static void print(char[][] map) {
		for(char[] tmp: map) {
			for(char t: tmp) {
				System.out.print(t+" ");
			}
			System.out.println();
		}
	}
	
	
	static void dfs(int row, int col , boolean[] visit,int cnt) {
		ans =Math.max(ans, cnt);
		
		for(int i =0 ; i<4; i++) {
			int nrow = row+dr[i];
			int ncol = col+dc[i];
			if(nrow>=0&& nrow<r&& ncol>=0 && ncol<c && !visit[map[nrow][ncol]-'A']) {
				visit[map[nrow][ncol]-'A']=true;
				dfs(nrow,ncol,visit,cnt+1);
				visit[map[nrow][ncol]-'A']=false;
			}
		}
	}
}
