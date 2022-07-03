import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int n;
	static int[][] arr;
	static int ans = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= 100; i++) {
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					if (arr[a][b] == i) {
						arr[a][b] = 0;
					}
				}
			}
			boolean[][] visit = new boolean[n][n];
			int cnt = 0;
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					if (!visit[a][b] && arr[a][b] != 0) {
						visit[a][b] = true;
						dfs(a, b, visit);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);

		}
		System.out.println(ans);
	}

	static void print(int arr[][]) {
		for (int[] tmp : arr) {
			for (int t : tmp) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}

	static void dfs(int row, int col, boolean visit[][]) {
		for (int i = 0; i < 4; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];

			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && !visit[nrow][ncol] && arr[nrow][ncol] != 0) {
				visit[nrow][ncol] = true;
				dfs(nrow, ncol, visit);
			}
		}
	}

}
