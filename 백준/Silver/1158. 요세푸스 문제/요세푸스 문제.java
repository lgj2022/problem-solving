import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> ans = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (!queue.isEmpty()) {
			for (int j = 1; j <= m; j++) {
				int temp = queue.poll();
				if (j == m) {
					ans.offer(temp);
				} else
					queue.offer(temp);
			}
		}
		System.out.print("<");
		while(ans.size()!=1) {
			System.out.print(ans.poll()+", ");
		}
		System.out.print(ans.poll());
		System.out.print(">");
	}
}
