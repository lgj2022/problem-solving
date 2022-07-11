import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] al;
	static int max=0;
	static int maxnode= 0;
	static class Node {
		int node;
		int weight;

		public Node(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		al = new ArrayList[n + 1];

		for (int i = 0; i < n+1; i++) {
			al[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			al[s].add(new Node(e, w));
			al[e].add(new Node(s, w));
		}
		boolean visit[] = new boolean[n+1];
		visit[1]=true;
		dfs(1,0,visit);
		visit[1]=false;
		visit[maxnode]=true;
		dfs(maxnode,0,visit);
		System.out.println(max);
	}

	private static void dfs(int start, int cost, boolean[] visit) {
		if(cost>max) {
			max= cost;
			maxnode=start;
		}
		
		
		for(Node current : al[start]) {
			if(!visit[current.node]) {
				visit[current.node]=true;
				dfs(current.node, cost+current.weight , visit);
				visit[current.node]=false;
			}
		}
		
	}
}
