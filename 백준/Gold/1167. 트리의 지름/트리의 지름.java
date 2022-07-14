import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int node;
		int weight;
		public Node(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		
		
	}
	static ArrayList<Node> [] al;
	static int maxdis=-1;
	static int maxidx=-1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		 al = new ArrayList[n+1];
		for (int i = 0; i < al.length; i++) {
			al[i]= new ArrayList<Node>();
		}
		
		for (int i = 0; i <n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int parent= Integer.parseInt(st.nextToken());
			
			while(true) {
			int child= Integer.parseInt(st.nextToken());
			if(child==-1) {
				break;
			}
			int weight = Integer.parseInt(st.nextToken());
			
			al[parent].add(new Node(child,weight));
			}
		}
		
		
		boolean visit[] = new boolean [n+1];
		visit[1]=true;
		dfs(1,0,visit);
		visit = new boolean [n+1];
		visit[maxidx]=true;
		dfs(maxidx,0,visit);
		
		System.out.println(maxdis);
	}
	private static void dfs(int current, int cost, boolean[] visit) {
		// TODO Auto-generated method stub
		if(maxdis<cost) {
			maxdis = cost;
			maxidx = current;
		}
		
		
		for(int i=0; i<al[current].size(); i++) {
			Node no = al[current].get(i);
			if(!visit[no.node]) {
				visit[no.node]=true;
				dfs(no.node,cost+no.weight,visit);
				visit[no.node]=false;
			}
		}
		
	}
	
}
