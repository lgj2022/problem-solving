import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = { 1, -1, 0, 0, 0, 0 };
	static int dc[] = { 0, 0, 1, -1, 0, 0 };
	static int dh[] = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		Queue<int[]> que = new LinkedList<>();

		int map[][][] = new int[r][c][h];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int z = 0; z < c; z++) {
					map[j][z][i] = Integer.parseInt(st.nextToken());
					if (map[j][z][i] == 1) {
						que.add(new int[] { j, z, i });
					}
				}
			}
		}

		int ans = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] current = que.poll();
				int cr = current[0];
				int cc = current[1];
				int ch = current[2];

				for (int i1 = 0; i1 < 6; i1++) {
					int nrow = cr + dr[i1];
					int ncol = cc + dc[i1];
					int nheight = ch + dh[i1];
					if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c && nheight >= 0 && nheight < h
							&& map[nrow][ncol][nheight] == 0) {
						map[nrow][ncol][nheight] = 1;
						que.add(new int[] { nrow, ncol, nheight });
					}

				}

			}
			ans++;
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {
				for (int z = 0; z < c; z++) {
					if (map[j][z][i] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		if (ans - 1 == 0) {
			System.out.println(0);
		} else {
			System.out.println(ans - 1);
		}
	}
}
