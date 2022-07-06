import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int node;
		int weight;
		
		public Edge(int node, int weight) {
			this.node= node;
			this.weight= weight;
		}
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		@Override
		public String toString() {
			return "Edge [node=" + node + ", weight=" + weight + "]";
		}
		
		
	}
	static ArrayList<Edge>[] al ;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[n+1];
		
		for (int i = 0; i < n+1; i++) {
			al[i]= new ArrayList<Edge>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			al[s].add(new Edge(e,w));
		}
		
		int ans = -1;
		
		for (int i = 1; i < n+1; i++) {
			ans = Math.max(ans,dikstra(i,x)+dikstra(x,i));
		}
		System.out.println(ans);
	}

	private static int dikstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int d [] = new int [n+1];
		Arrays.fill(d,987654321);
		
		boolean visit[] = new boolean [n+1];
		pq.add(new Edge(start,0));
		d[start]=0;
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			if(visit[current.node]) {
				continue;
			}
			
			
			visit[current.node]=true;
			if(current.node==end) {
				return current.weight;
			}
			for (int i = 0; i < al[current.node].size(); i++) {
				if(!visit[al[current.node].get(i).node] && d[al[current.node].get(i).node]>=d[current.node]+al[current.node].get(i).weight) {
					d[al[current.node].get(i).node] = d[current.node]+al[current.node].get(i).weight;
					pq.add(new Edge(al[current.node].get(i).node,d[al[current.node].get(i).node]));
					
				}
				
				
			}
			
		}
		
		return 987654321;
	}
}
