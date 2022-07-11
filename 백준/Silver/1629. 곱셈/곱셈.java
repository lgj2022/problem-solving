import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		
		long ans = pow(a,b,c);
		
		System.out.println(ans);
	}

	private static long pow(int a, int b, int c) {
		if(b==1) {
			return a%c;
		}
		long tmp = pow(a,b/2,c);
		
		if(b%2==0) {
			return tmp*tmp%c;
		}
		return (tmp*tmp%c)*a%c;
	}
}
