import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int n ;
	static int ans = 987654321;
	static public void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int [n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		//printmap();
		boolean [] visit = new boolean [n];
		// n/2 개뽑기
		teamselect(new ArrayList<Integer>(),0,visit);
		System.out.println(ans);
		
	}
	private static void teamselect(ArrayList<Integer> al , int idx,boolean [] visit) {
		// TODO Auto-generated method stub
		if(al.size()==n/2) {
			ArrayList<Integer>bl = new ArrayList<Integer>();
			for (int i = 0; i < visit.length; i++) {
				if(!visit[i]) {
					bl.add(i);
				}
			}
			
			int alsum= teampower(al);
			int blsum =teampower(bl);
			//System.out.println(al.toString());
			//System.out.println(bl.toString());
			ans = Math.min(ans, Math.abs(alsum-blsum));
			
			return;
		}
		for (int i = idx; i < n; i++) {
			al.add(i);
			visit[i]=true;
			teamselect(al, i+1,visit);
			al.remove(al.size()-1);
			visit[i]=false;
		}
		
	}
	private static int teampower(ArrayList<Integer> al) {
		int sum = 0;
		for (int i = 0; i < al.size(); i++) {
			for (int j = i+1; j < al.size(); j++) {
				sum+=map[al.get(i)][al.get(j)];
				sum+=map[al.get(j)][al.get(i)];
			}
		}
		return sum;
		
	}
	private static void printmap() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
