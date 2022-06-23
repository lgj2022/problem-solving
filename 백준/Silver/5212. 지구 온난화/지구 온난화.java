import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dr [] = {1,-1,0,0};
	static int dc [] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char [][] map = new char[r][c];
		for(int i=0; i<r; i++) {
			String s = bf.readLine();
			for(int j=0; j<c; j++) {
				map[i][j]=s.charAt(j);
			}
		}
		char [][] map1 = new char[r][c];
		for(int i=0; i<map.length; i++) {
			map1[i]=map[i].clone();
		}
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]=='X') {
					if(check(map,i,j)) {
						map1[i][j]='.';
					}
				}
			}
		}
		int minrow =10;
		int mincol =10;
		int maxrow =0;
		int maxcol =0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map1[i][j]=='X') {
					minrow=Math.min(minrow,i);
					mincol=Math.min(mincol,j);
					maxrow=Math.max(maxrow,i);
					maxcol=Math.max(maxcol,j);
				}
			}
		}
		
		for(int i=minrow ; i<=maxrow; i++) {
			for(int j= mincol ; j<=maxcol ; j++) {
				System.out.print(map1[i][j]);
			}
			System.out.println();
		}
	}
	private static boolean check(char[][] map, int row, int col) {
		int cnt =0;
		for(int i =0 ; i<4; i++ ) {
			int nrow = row+dr[i];
			int ncol = col+dc[i];
			if(nrow<map.length && nrow>=0 && ncol<map[0].length && ncol>=0 ) {
				if(map[nrow][ncol]=='.') {
				cnt++;
				}
			}
			else
				cnt++;
		}
		if(cnt>=3) {
			return true;
		}
		else
			return false;
	}
	static void print(char[][] map) {
		for(char[] tmp: map) {
			for(char t: tmp) {
				System.out.print(t+" ");
			}
			System.out.println();
		}
	}
}
