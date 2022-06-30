import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class edge implements Comparable<edge>{
		int node;
		long weight;
		
	

		public edge(int node,long d) {
			this.node=node;
			this.weight=d;
		}



		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return (int) (this.weight-o.weight);
		}



		@Override
		public String toString() {
			return "edge [node=" + node + ", weight=" + weight + "]";
		}
		
		
	}
	static int n;
	static ArrayList<edge> al[];
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		al= new ArrayList[n+1];
		
		for (int i = 0; i < n+1; i++) {
			al[i]=new ArrayList<edge>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			al[s].add(new edge(e,w));
			al[e].add(new edge(s,w));
		}
		st = new StringTokenizer(bf.readLine());
		int s1 = Integer.parseInt(st.nextToken());
		int s2 = Integer.parseInt(st.nextToken());
		//System.out.println("--------------------------");
		//System.out.println(diskstra(1,s1));
		//System.out.println(diskstra(s1,s2));
		//System.out.println(diskstra(s2,n));
		//System.out.println("--------------------------");
		long ans = Math.min(diskstra(1,s2)+diskstra(s2,s1)+diskstra(s1,n),diskstra(1,s1)+diskstra(s1,s2)+diskstra(s2,n));
		if(ans>=987654321) {
			System.out.println(-1);
		}
		else {
		System.out.println(ans);
		}
	}
	private static long diskstra(int start, int end) {
		
		PriorityQueue<edge> pq = new PriorityQueue<>();
		long d[] = new long [n+1];
		boolean visit[] = new boolean[n+1];
		
		Arrays.fill(d, 987654321);
		d[start]=0;
		pq.add(new edge(start,0));
		while(!pq.isEmpty()) {
			edge current = pq.poll();
			//System.out.println(current);
			//System.out.println(al[current.node].toString());
			if(visit[current.node]) {
				continue;
			}
			visit[current.node]=true;
			if(current.node==end) {
				break;
			}
			for (int i = 0; i < al[current.node].size(); i++) {
				
				if(!visit[al[current.node].get(i).node] && d[current.node]+al[current.node].get(i).weight<d[al[current.node].get(i).node]) {
					d[al[current.node].get(i).node]= d[current.node]+al[current.node].get(i).weight;
					pq.add(new edge(al[current.node].get(i).node,d[al[current.node].get(i).node]));
				}
			}
			
		}
		return d[end];
		
	}
}
