import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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


		public int compareTo(Node o) {
			return this.weight-o.weight;
		}


		@Override
		public String toString() {
			return "Node [node=" + node + ", weight=" + weight + "]";
		}
		
		
		
	}
	static int n;
	static int m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(bf.readLine());
		 m = Integer.parseInt(bf.readLine());
		
		ArrayList<Node> al[] = new ArrayList[n+1];
		for (int i = 1; i < al.length; i++) {
			al[i]=new ArrayList<Node>();
		}
		
		
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			al[s].add(new Node(e,w));
		}
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		//System.out.println(start+" "+end);
		dikstra(start,end,al);
	}
	private static void dikstra(int start, int end, ArrayList<Node>[] al) {
		// TODO Auto-generated method stub
		
		int [] d= new int[n+1];
		Arrays.fill(d, 987654321);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		boolean visit [] = new boolean[n+1];
		d[start]=0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			//System.out.println(current);
			if(visit[current.node]) {
				continue;
			}
			
			if(current.node == end) {
				System.out.println(current.weight);
			}
			visit[current.node]=true;
			
			for (int i = 0; i < al[current.node].size(); i++) {
				//System.out.println(al[current.node].toString());
				if(!visit[al[current.node].get(i).node] && d[al[current.node].get(i).node]>d[current.node]+al[current.node].get(i).weight) {
					d[al[current.node].get(i).node]=d[current.node]+al[current.node].get(i).weight;
					pq.add(new Node(al[current.node].get(i).node,d[al[current.node].get(i).node]));
				}
			}
		}
		
		if(d[end]==987654321) {
			System.out.println(-1);
		}
	}
}
