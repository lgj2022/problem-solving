
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int ans = 0;
	static int dr[] = { 1, 1 };
	static int dc[] = { 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		map = new int[n][n];

		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], -1);
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (i > 0) {
					if (j>0 && map[i - 1][j - 1] > map[i - 1][j]) {
						map[i][j] = map[i - 1][j - 1] + map[i][j];
					} else {
						map[i][j] = map[i - 1][j] + map[i][j];
					}
				}

				ans = Math.max(ans, map[i][j]);
			}
		}
		
		System.out.println(ans);
	}

}
