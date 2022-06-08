import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int noad = Integer.parseInt(st.nextToken());
			int ad = Integer.parseInt(st.nextToken());
			int adcost = Integer.parseInt(st.nextToken());
			
			if(noad+adcost>ad) {
				System.out.println("do not advertise");
			}
			else if(noad+adcost<ad) {
				System.out.println("advertise");
			}
			else {
				System.out.println("does not matter");
			}
		}
	}
}
