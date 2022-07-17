import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map [][];
	static int ans [][];
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(bf.readLine());
		map = new int [n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		
		ans= new int [n][n];
		
		for (int i = 0; i < ans.length; i++) {
			bfs(i);
		}
		
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void bfs(int start) {
		// TODO Auto-generated method stub
		Queue<Integer> que = new LinkedList<>();
		boolean visit [] = new boolean[n];
		que.add(start);
		while(!que.isEmpty()) {
			int current = que.poll();
			
			for (int i = 0; i < map.length; i++) {
				if(map[current][i]==1 && !visit[i] ) {
					visit[i]=true;
					que.add(i);
				}
			}
		}
		
		
		for (int i = 0; i < visit.length; i++) {
			if(visit[i]) {
				ans[start][i]=1;
			}
		}
	}
}
