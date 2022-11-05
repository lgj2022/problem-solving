
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st =new StringTokenizer(bf.readLine());
		int arr[] = new int[n];
		for(int i =0; i<n ;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(arr));
		
		//2분탐색
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		
		int left =0;
		int right= arr[n-1];
		int mid = (left+right)/2;
		int cnt =0;
		long sum =0;
		int ans =0;
		while(left<=right) {
			//System.out.println("left"+left);
			//System.out.println("right"+right);
			
			mid = (left+right)/2;
			cnt++;
			//System.out.println("mid"+mid);
			sum=0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]-mid>0) {
					sum+=arr[i]-mid;
				}
			}
			//System.out.println("sum"+sum);
			//System.out.println("k"+k);
			if(sum>k) {
				left=mid+1;
				ans=mid;
				}
			else if(sum<k) {
				right=mid-1;
			}
			else {	
				ans =mid;
				break;
			}
		}
		System.out.println(ans);
	}
}
