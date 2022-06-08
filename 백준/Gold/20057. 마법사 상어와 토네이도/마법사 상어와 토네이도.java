import java.util.*;
import java.io.*;

public class Main {
	static int map[][];
	static int ans=0;
	// 왼 밑 우 위
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { -1, 0, 1, 0 };
	static int n;
	static int msr[][] = {{ 0, 1,-1, 2,-2, 1,-1, 1,-1},{ 2, 1, 1, 0, 0, 0, 0,-1,-1},{  0, 1,-1, 2,-2, 1,-1, 1,-1},{-2,-1,-1,0,0,0,0,1,1}};
	static int msc[][] = {{-2,-1,-1, 0, 0, 0, 0, 1, 1},{ 0,-1, 1, 2,-2, 1,-1, 1,-1},{ 2, 1, 1, 0, 0, 0, 0,-1,-1},{ 0,-1, 1, 2,-2, 1,-1, 1,-1}};
	static int per[] = {5,10,10,2,2,7,7,1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//printmap();

		int crow = n / 2;
		int ccol = n / 2;

		int dis = 1;
		int dir = 0;
		int cnt = 0;
		while (true) {
			if (crow == 0 && ccol == 0) {
				break;
			}
			if (cnt % 2 == 0 && cnt != 0) {
				dis = dis + 1;
			}
			cnt++;
			for (int i = 0; i < dis; i++) {
				crow = crow + dr[dir];
				ccol = ccol + dc[dir];
				// 토네이도 확산 수행
				movesend(crow, ccol, dir);
				//System.out.println();
				//printmap();
				//System.out.print(map[crow][ccol] + " ");
				if (crow == 0 && ccol == 0) {
					break;
				}
			}
			dir = (dir + 1) % 4;

		}
		System.out.println(ans);
	}

	private static void movesend(int crow, int ccol, int dir) {
		int total = map[crow][ccol];
		//System.out.println(total);
		int sum = 0;
		for (int i = 0; i < per.length; i++) {
			int nrow = crow+msr[dir][i];
			int ncol = ccol+msc[dir][i];
			if(nrow>=0 && ncol>=0 && nrow<n && ncol<n) {
				map[nrow][ncol]+=((map[crow][ccol]*per[i])/100);
				///System.out.println(((map[crow][ccol]*per[i])/100));
				sum+= map[crow][ccol]*per[i]/100;
				//printmap();
			}
			else {
				ans +=(map[crow][ccol]*per[i]/100);
				sum+= map[crow][ccol]*per[i]/100;
			}
		}
		map[crow][ccol]=0;
		int nrow = crow+dr[dir];
		int ncol = ccol+dc[dir];
		if(nrow>=0 && ncol>=0 && nrow<n && ncol<n) {
			map[nrow][ncol]+=(total-sum);
		}
		else {
			ans +=(total-sum);
		}
	}

	static void printmap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}


}
