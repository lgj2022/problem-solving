import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] map;
	static int[][] key;
	static ArrayList<Point>[] al;
	static ArrayList<Point> keylist = new ArrayList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt;

	public static class Point implements Comparable<Point> {
		int start;
		int end;
		int weight;

		public Point(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.weight = cost;
		}

		@Override
		public int compareTo(Point p) {
			return this.weight - p.weight;
		}

		@Override
		public String toString() {
			return "Point [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][n];
		key = new int[n][n];
		al = new ArrayList[m + 1];
		for (int i = 0; i <= m; i++)
			al[i] = new ArrayList<>();

		int idx = 0;
		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S' || map[i][j] == 'K') {
					key[i][j] = idx;
					keylist.add(new Point(i, j, 0));
					idx++;
				}
			}
		}
		//System.out.println(keylist.toString());
		for (Point p : keylist) {
			bfs(p, key[p.start][p.end]);
		}
		/*
		for (ArrayList<Point> p : al) {
			System.out.println(p.toString());
		}*/

		int ans = prim();
		System.out.println(ans);
	}

	private static void bfs(Point p, int x) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		queue.add(p);
		// System.out.println(p);
		visited[p.start][p.end] = true;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			//System.out.println(current);
			if (map[current.start][current.end] == 'K' || map[current.start][current.end] == 'S') {
				// System.out.println(current);

				int y = key[current.start][current.end];
				if (x != y) {
					al[x].add(new Point(x, y, current.weight));
				}
			}

			for (int i = 0; i < 4; i++) {
				int nrow = current.start + dx[i];
				int ncol = current.end + dy[i];

				if (nrow > 0 && nrow < n && ncol > 0 && ncol < n && map[nrow][ncol] != '1' && !visited[nrow][ncol]) {
					visited[nrow][ncol] = true;
					queue.add(new Point(nrow, ncol, current.weight + 1));
				}
			}
		}
	}

	public static int prim() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[m + 1];
		int answer = 0;
		int cnt = 0;
		pq.add(new Point(0, 0, 0));
		// visited[0]=true;
		while (!pq.isEmpty()) {
			Point current = pq.poll();
			//System.out.println(current);
			if (visited[current.end]) {
				continue;
			}
			visited[current.end] = true;
			answer = answer + current.weight;
			//System.out.println(answer);
			for (int i = 0; i < al[current.end].size(); i++) {
				if (!visited[al[current.end].get(i).end]) {
					pq.add(al[current.end].get(i));
					// System.out.println("추가");
					// System.out.println(al[current.end].get(i));
				}
			}

		}
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]) {
				answer=-1;
			}
		}
		return answer;
	}

}
