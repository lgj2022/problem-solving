import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public int solution(int[] arr, int num) {
		int high = arr.length-1, low = 0, mid = 0;
		
		while(low <= high) {
			mid = (high + low) / 2;
			
			if(arr[mid] == num)
				return 1;
			else if(arr[mid] > num)
				high = mid -1;
			else
				low = mid + 1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[scan.nextInt()];
		
		for(int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();
		Arrays.sort(arr);
		
		int m = scan.nextInt();
		for(int i = 0; i < m; i++)
			System.out.println(new Main().solution(arr, scan.nextInt()));
	}
}