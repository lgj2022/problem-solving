import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[][] map;
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int ans ;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		ans =0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(check()==0) {
			System.out.println(0);
		}
		else {
			ans =check();
		System.out.println(bfs(0, 0));
		}
		System.out.println(ans);
	}

	private static int bfs(int row, int col) {
		int cnt =0;
		while (true) {
			cnt++;
			boolean visit[][] = new boolean[r][c];
			Queue<int[]> que = new LinkedList<>();
			que.add(new int[] { row, col });
			visit[row][col] = true;
			while (!que.isEmpty()) {
				int current[] = que.poll();

				for (int i = 0; i < 4; i++) {
					int nr = current[0] + dr[i];
					int nc = current[1] + dc[i];

					if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						que.add(new int[] { nr, nc });
					}

					if (nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 1 && !visit[nr][nc]) {
						map[nr][nc]++;
					}
				}
			}
		
			if(check()==0) {
				break;
			}
			else {
				ans=check();
			}
		}
		return cnt;

	}

	private static int check() {
		int cnt=0;
		for(int i =0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]>1) {
					map[i][j]=0;
				}
				if(map[i][j]==1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
