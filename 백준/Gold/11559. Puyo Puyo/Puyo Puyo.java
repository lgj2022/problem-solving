import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };
	static int r = 12;
	static int c = 6;
	static char[][] map = new char[12][6];
	static int flag;
	static ArrayList<int[]> al;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < r; i++) {
			String s = bf.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		/*
		 * for (char[] tmp : map) { System.out.println(Arrays.toString(tmp)); }
		 */
		int cnt = 0;
		flag = 0;
		while (flag == 0) {
			
			al = new ArrayList<>();
			boolean visit[][] = new boolean[r][c];
			flag = 1;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (!visit[i][j] && map[i][j] != '.') {
						visit[i][j] = true;
						ArrayList<int[]> cl = new ArrayList<>();
						cl.add(new int[] { i, j });
						check(i, j, visit, cl);
						if (cl.size() >= 4) {
							// 삭제 리스트에 add

							al.addAll(cl);
							flag = 0;
						}

					}
				}
			}
			if(al.size()!=0) {
				cnt++;
			}
			for (int tmp[] : al) {
				map[tmp[0]][tmp[1]] = '.';
				
			}

			// 삭제 후
			/*
			 * for (char[] tmp : map) { System.out.println(Arrays.toString(tmp)); }
			 */
			// 중력 후
			gravity();
			/*
			 * System.out.println("---------------------중력 후 ------------------"); for
			 * (char[] tmp : map) { System.out.println(Arrays.toString(tmp)); }
			 */
		}
		System.out.println(cnt);
	}

	public static void gravity() {

		for (int i = 0; i < c; i++) {
			for (int j = r - 1; j > 0; j--) {

				if (map[j][i] == '.') {

					for (int k = j - 1; k >= 0; k--) {
						if (map[k][i] != '.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
			}
		}

	}

	private static void check(int row, int col, boolean[][] visit, ArrayList<int[]> current) {
		// System.out.println(row+" "+col);
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			if (nrow >= 0 && nrow < 12 && ncol >= 0 && ncol < 6 && map[row][col] == map[nrow][ncol]
					&& !visit[nrow][ncol]) {
				visit[nrow][ncol] = true;
				current.add(new int[] { nrow, ncol });
				check(nrow, ncol, visit, current);
			}
		}
	}
}
