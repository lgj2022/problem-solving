
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int ans;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] visit = new boolean[r][c];

		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				visit[i][j] = true;
				dfs(i, j, 0, map[i][j], visit);
				visit[i][j] = false;

				if (i + 1 < r && j + 1 < c && j - 1 >= 0) { //ㅜ
					int sum = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i][j - 1];
					ans = Math.max(ans, sum);
				}
				if (i + 1 < r && i - 1 >= 0 && j - 1 >= 0) {//ㅓ
					int sum = map[i][j] + map[i + 1][j] + map[i - 1][j] + map[i][j - 1];
					ans = Math.max(ans, sum);
				}
				if (i - 1 >= 0 && j + 1 < c && j - 1 >= 0) {//ㅗ
					int sum = map[i][j] + map[i - 1][j] + map[i][j + 1] + map[i][j - 1];
					ans = Math.max(ans, sum);
				}
				if (i + 1 < r && i - 1 >= 0 && j + 1 < c) {//ㅏ
					int sum = map[i][j] + map[i + 1][j] + map[i - 1][j] + map[i][j + 1];
					ans = Math.max(ans, sum);
				}
			}
		}

		System.out.println(ans);
	}

	public static void dfs(int row, int col, int cnt, int sum, boolean[][] visit) {
		if (cnt >= 3) {
			ans = (ans < sum) ? sum : ans;
			return;
		}

		for (int i = 0; i < 4; ++i) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];

			if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && !visit[nrow][ncol]) {
				visit[nrow][ncol] = true;
				dfs(nrow, ncol, cnt + 1, sum + map[nrow][ncol], visit);
				visit[nrow][ncol] = false;
			}
		}
	}
}