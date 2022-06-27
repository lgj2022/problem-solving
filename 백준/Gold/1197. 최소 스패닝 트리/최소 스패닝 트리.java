import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class edge implements Comparable<edge> {
		int start;
		int end;
		int weight;

		public edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		ArrayList<edge> al = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			al.add(new edge(a, b, c));
		}
		Collections.sort(al);

		int parent[] = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		int ans = 0;
		for(int i=0; i<al.size(); i++) {
			edge current = al.get(i);
			if(!check(current.start,current.end,parent)) {
				union(current.start,current.end,parent);
				ans+=current.weight;
			}
		}

		System.out.println(ans);
	}

	static int findParent(int a, int parent[]) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = findParent(parent[a], parent);
		}
	}

	static void union(int a, int b, int parent[]) {
		a = findParent(a, parent);
		b = findParent(b, parent);

		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	static boolean check(int a, int b, int[] parent) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		if (a == b) {
			return true;
		} else {
			return false;
		}
	}
}
