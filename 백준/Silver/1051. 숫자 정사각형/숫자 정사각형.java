
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int row , col;
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		arr = new int[row][col];
		
		for(int i=0; i<row; i++) {
			String s = bf.readLine();
			for(int j=0; j<col ; j++) {
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		
		//print(arr);
		int ans=1;
		int tmp=Math.min(row, col);
		for(int i= tmp ; i>0; i--) {
			ans=Math.max(ans, check(i));
		}
		System.out.println(ans);
	}
	static void print(int arr[][]) {
		for(int tmp[] :arr) {
			for(int t: tmp) {
				System.out.print(t+" ");
			}
			System.out.println();
		}
	}
	
	
	static int check(int n) {
		for(int i=0; i<arr.length-n; i++) {
			for(int j=0; j<arr[0].length-n; j++) {
				if(arr[i][j]==arr[i][j+n]&& arr[i][j+n]==arr[i+n][j]&&arr[i+n][j]==arr[i+n][j+n]) {
					return (n+1)*(n+1);
				}
			}
		}
		return -1;
	}
}
