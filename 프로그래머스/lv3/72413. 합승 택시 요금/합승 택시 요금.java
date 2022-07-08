import java.util.*;
class Solution {
    public static class Edge implements Comparable<Edge> {
		int beforenode;
		int node;
		int weight;
		
		public int compareTo(Edge o) {
			return this.weight -o.weight;
		}
		
		public Edge(int beforenode,int node,int weight) {
			this.beforenode=beforenode;
			this.node=node;
			this.weight=weight;
		}

		@Override
		public String toString() {
			return "Edge [beforenode=" + beforenode + ", node=" + node + ", weight=" + weight + "]";
		}
		
		
	}
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		//n개 
		
		//일단 업데이트 양방향 가능
		ArrayList<Edge>[] al = new ArrayList[n+1];
		
		for (int i = 0; i < al.length; i++) {
			al[i]=new ArrayList<Edge>();
		}
		
		for (int i = 0; i < fares.length; i++) {
			int tmp[] = fares[i];
			int st = tmp[0];
			int	en = tmp[1];
			int we = tmp[2];
			al[st].add(new Edge(st,en,we));
			al[en].add(new Edge(en,st,we));
		}
		//pq구현
		int start[] = dikstra(al,s,n);
		int ans = start[a]+start[b];
		for (int i = 1; i < n+1 ; i++) {
			int current[] = dikstra(al, i, n);
			if(start[i]!=987654321 && current[a] != 987654321 &&current[b]!=987654321)
			ans = Math.min(ans,start[i]+current[a]+current[b]);
		}
		
		return ans;
	}

	private static int[] dikstra( ArrayList<Edge>[] al, int s, int n) {

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int d[] = new int[n+1];
		Arrays.fill(d, 987654321);
		boolean visit[] = new boolean [n+1];
		pq.add(new Edge(0,s,0));
		d[s]=0;
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			if(visit[current.node]) {
				continue;
			}
			
			
			visit[current.node]=true;
			
			for (int i = 0; i < al[current.node].size(); i++) {
				if(!visit[al[current.node].get(i).node] && d[al[current.node].get(i).node]>=d[current.node]+al[current.node].get(i).weight) {
					d[al[current.node].get(i).node]=d[current.node]+al[current.node].get(i).weight;
					pq.add(new Edge(al[current.node].get(i).beforenode,al[current.node].get(i).node,d[al[current.node].get(i).node]));
					
				}
			}
			
		}
		return d;
		
	}
}