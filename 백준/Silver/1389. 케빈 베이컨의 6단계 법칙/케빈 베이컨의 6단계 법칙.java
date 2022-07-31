
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static int[][] d;

	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList();
		boolean[] visit = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			if (map[x][i] == 1) {
				visit[i] = true;
				d[x][i] = 1;
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int y = q.poll();

			for (int i = 1; i <= n; i++) {
				if (map[y][i] == 1 && visit[i] == false) {
					q.add(i);
					d[x][i] = d[x][y] + 1;
					visit[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n + 1][n + 1];
		d = new int[n + 1][n + 1];
		int e = sc.nextInt();
		int min = 7 * n;
		int idx = 0;

		for (int i = 1; i <= e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}

		for (int i = 1; i <= n; i++) {
			bfs(i);
		}

		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += d[i][j];
			}
			if (sum < min) {
				min = sum;
				idx = i;
			}
		}

		System.out.println(idx);
	}
}