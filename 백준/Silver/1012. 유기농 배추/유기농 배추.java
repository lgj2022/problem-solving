import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, n;
	static int arr[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			m = Integer.parseInt(st.nextToken()); // col
			n = Integer.parseInt(st.nextToken()); // row
			int k = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[b][a] = 1;
			}


			int cnt = 0;
			boolean visit[][] = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1 && !visit[i][j]) {
						visit[i][j] = true;
						dfs(i, j, visit);
						//bfs(i, j, visit);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void bfs(int row, int col, boolean[][] visit) {
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.add(new int[] { row, col });

		while (!queue.isEmpty()) {
			int tmp[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nrow = tmp[0] + dr[i];
				int ncol = tmp[1] + dc[i];
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visit[nrow][ncol] && arr[nrow][ncol] == 1) {
					visit[nrow][ncol] = true;
					queue.add(new int[] {nrow,ncol});
				}
			}
		}
	}

	private static void dfs(int row, int col, boolean[][] visit) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visit[nrow][ncol] && arr[nrow][ncol] == 1) {
				visit[nrow][ncol] = true;
				dfs(nrow, ncol, visit);
			}
		}
	}

	static void print(int arr[][]) {
		for (int[] tmp : arr) {
			for (int t : tmp) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}
}
