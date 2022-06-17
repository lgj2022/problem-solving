
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 5 3 20 10 10 20 20 30 1 3 2 4 5 4
	 */

	static class edge implements Comparable<edge> {
		int[] node = new int[2];
		int distance;

		edge(int s, int e, int distance) {
			this.node[0] = s;
			this.node[1] = e;
			this.distance = distance;
		}

		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		ArrayList<edge> al = new ArrayList<edge>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int parent[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int distance = Math.min(arr[s], arr[e]);
			al.add(new edge(s, e, distance));
		}

		Collections.sort(al);
		int sum = 0;
		for (edge tmp : al) {
			// System.out.println(tmp.node[0]+" "+ tmp.node[1]+" "+ tmp.distance);
			if (!findParent(parent, tmp.node[0], tmp.node[1])) {
				unionParent(parent, tmp.node[0], tmp.node[1],arr);
			}
		}
		int check[] = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			int tmp = getParent(parent, i);
			check[tmp]++;
		}

		for (int i = 1; i < n + 1; i++) {
			if (check[i] != 0) {
				sum += arr[i];
			}
		}

		if (sum > k) {
			System.out.println("Oh no");
		} else {
			System.out.println(sum);
		}
	}

	static int getParent(int parent[], int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = getParent(parent, parent[x]);

	}

	static void unionParent(int parent[], int a, int b,int arr[]) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if (arr[a] < arr[b])
			parent[b] = a;
		else
			parent[a] = b;
	}

	static boolean findParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if (a == b) {
			return true;
		} else {
			return false;
		}
	}
}
