
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int node;
		int weight;
		public Node(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		
		ArrayList<Node> []al  = new ArrayList[n+1];
		
		
		for (int i = 0; i < n+1 ; i++) {
			al[i]= new ArrayList<Node>();
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			al[start].add(new Node(end,weight));
			al[end].add(new Node(start,weight));
		}
		
		
		PriorityQueue <Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		boolean visit[] = new boolean[n+1];
		int ans =0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			if(visit[current.node]) {
				continue;
			}
			visit[current.node]=true;
			ans += current.weight;
			
			for (int i = 0; i < al[current.node].size(); i++) {
				if(!visit[al[current.node].get(i).node]) {
					pq.add(al[current.node].get(i));
				}
			}
			
			if(++cnt==n) {
				break;
			}
			
		}
		System.out.println(ans);
	}
}
