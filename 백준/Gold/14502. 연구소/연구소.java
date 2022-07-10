import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	static int map[][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c =Integer.parseInt(st.nextToken());
		ans =-1;
		map = new int[r][c];
		ArrayList<int[]> al = new ArrayList<>();
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<c; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					al.add(new int[] {i,j});
				}
			}
		}
		/*
		
		for(int tmp[] : map) {
			System.out.println(Arrays.toString(tmp));
		}*/
		int [] sel = new int[3];
		sel(al,sel,0,0);
		System.out.println(ans);
		
	}
	private static void sel(ArrayList<int[]> al, int[] sel ,int idx,int cnt) {
		// TODO Auto-generated method stub
		if(cnt==3) {
			//System.out.println(Arrays.toString(sel));
			//맵복사
			int[][] cpy = mapcopy();
			for (int i = 0; i < sel.length; i++) {
				int current[] =al.get(sel[i]);
				cpy[current[0]][current[1]]=1;
			}
			//바이러스 검사
			boolean visit[][] = new boolean[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(cpy[i][j]==2 && !visit[i][j]) {
						virus(i,j,visit,cpy);
					}
				}
			}
			int count =0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(cpy[i][j]==0) {
						count++;
					}
				}
			}
			ans =Math.max(ans, count);
			return;
		}
		for(int i =idx; i<al.size(); i++) {
			sel[cnt]=i;
			sel(al,sel,i+1,cnt+1);
		}
	}
	private static void virus(int row, int col, boolean[][] visit, int[][] cpy) {
		// TODO Auto-generated method stub
		for(int i =0; i<4; i++) {
			int nr = row+dr[i];
			int nc = col+dc[i];
			if(nr>=0 && nr<r && nc>=0 && nc<c && !visit[nr][nc] && cpy[nr][nc]!=1) {
				visit[nr][nc]=true;
				cpy[nr][nc]=2;
				virus(nr,nc,visit,cpy);
			}
		}
	}
	private static int[][] mapcopy() {
		int [][] cpy = new int [r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cpy[i][j]=map[i][j];
			}
		}
		return cpy;
	}
}
