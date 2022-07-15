import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int e =Integer.parseInt(st.nextToken()); //1~15
		int s =Integer.parseInt(st.nextToken()); //1~28
		int m =Integer.parseInt(st.nextToken()); //1~19
		
		
		int starte=1;
		int starts=1;
		int startm=1;
		int cnt =1;
		while(true) {
			if(starte>=16) {
				starte=1;
			}
			if(starts>=29) {
				starts=1;
			}
			if(startm>=20) {
				startm=1;
			}
			if(starte==e && starts ==s && startm==m) {
				break;
			}
			
			starte++;
			starts++;
			startm++;
			cnt++;
		}
		System.out.println(cnt);
	}
}
