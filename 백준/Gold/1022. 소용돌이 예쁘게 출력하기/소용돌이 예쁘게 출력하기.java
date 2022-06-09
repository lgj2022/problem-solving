import java.util.*;
import java.io.*;

public class Main {
	// 우 위 좌 밑
	static int dr[] = { 0, -1, 0, 1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		int max = Math.max(Math.max(Math.max(Math.abs(r1), Math.abs(c1)), Math.abs(r2)), Math.abs(c2));
		map = new int[r2 - r1 + 1][c2 - c1 + 1];
		int startrow = max;
		int startcol = max;
		int count = 1;
		if (startrow >= max + r1 && startrow <= max + r2 && startcol >= max + c1 && startcol <= max + c2) {
			map[startrow - max - r1][startcol - max - c1] = count ;
		}

		int dis = 1;
		int dir = 0;
		int cnt = 0;
		int mval = 0;

		while (true) {
			if (startrow == max * 2 && startcol == max * 2) {
				break;
			}

			for (int i = 0; i < dis; i++) {
				startrow = startrow + dr[dir];
				startcol = startcol + dc[dir];

				if (startrow >= max + r1 && startrow <= max + r2 && startcol >= max + c1 && startcol <= max + c2) {
					map[startrow - max - r1][startcol - max - c1] = count + 1;
					mval = Math.max(mval, count + 1);
				}

				if (startrow == max * 2 && startcol == max * 2) {
					break;
				}
				count++;
			}

			cnt++;

			if (cnt % 2 == 0) {

				dis++;
			}
			dir = (dir + 1) % 4;

		}
		int length = 0;
		while (mval > 0) {
			mval /= 10;
			length++;
		}
		if(length==0) {
			length=1;
		}
		for (int i = 0; i <= r2 - r1; i++) {
			for (int j = 0; j <= c2 - c1; j++) {
				System.out.format("%" + length + "d ", map[i][j]);
			}
			System.out.println();
		}

	}

}
