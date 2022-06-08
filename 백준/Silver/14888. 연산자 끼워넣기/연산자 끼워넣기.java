import java.util.*;
import java.io.*;

public class Main {
	static int maxans = -987654321;
	static int minans = 987564321;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int arr[] = new int[4];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			al.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(bf.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1] = Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());
		arr[3] = Integer.parseInt(st.nextToken());

		ArrayList<Integer> pl = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i]; j++) {
				pl.add(i);
			}
		}
		//System.out.println(pl.toString());

		permutation(al, pl, new ArrayList<Integer>(), new boolean[pl.size()]);
		System.out.println(maxans);
		System.out.println(minans);
	}

	private static void permutation(ArrayList<Integer> al, ArrayList<Integer> pl, ArrayList<Integer> current,
			boolean visit[]) {
		// TODO Auto-generated method stub

		if (current.size() == pl.size()) {
			int sum = al.get(0);
			//System.out.println(sum);
			for (int i = 0; i < current.size(); i++) {
				if (current.get(i) == 0) {
					sum=sum+al.get(i+1);
				} else if (current.get(i) == 1) {
					sum=sum-al.get(i+1);
				} else if (current.get(i) == 2) {
					sum=sum*al.get(i+1);
				} else {
					sum=sum/al.get(i+1);
				}
			}
			maxans= Math.max(sum, maxans);
			minans= Math.min(sum, minans);
			
			return;
		}
		for (int i = 0; i < pl.size(); i++) {
			if (!visit[i]) {
				current.add(pl.get(i));
				visit[i] = true;
				permutation(al, pl, current, visit);
				current.remove(current.size() - 1);
				visit[i] = false;
			}
		}

	}
}
