import java.util.*;
import java.io.*;
public class Main {
	static int arr[];
	static int ans =0;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(bf.readLine());
		StringTokenizer st =new StringTokenizer(bf.readLine());
		arr = new int [n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(arr));
		boolean visit[] = new boolean [n];
		permutation(new ArrayList<Integer>(),visit);
		
		
		System.out.println(ans);
		
	}
	private static void permutation(ArrayList<Integer> al, boolean[] visit) {
		// TODO Auto-generated method stub
		if(al.size()==arr.length) {
			int sum = 0;
			for (int i = 0; i < al.size()-1; i++) {
				sum+=Math.abs(al.get(i)-al.get(i+1));
				
			}
			ans = Math.max(ans,sum);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!visit[i]) {
				visit[i]=true;
				al.add(arr[i]);
				permutation(al, visit);
				visit[i]=false;
				al.remove(al.size()-1);
			}
		}
	}
}
