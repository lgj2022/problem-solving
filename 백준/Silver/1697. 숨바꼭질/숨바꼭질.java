import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int check[] = new int [100001];
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]); 
		
		if(n==k) { 
			System.out.println("0"); 
			return;
		}
		bfs(n,k); 
		
		System.out.println(check[k]); 
		
		
		
	}
	public static void bfs(int a,int k) { 
		Queue<Integer> queue = new LinkedList();
		
		check[a] = 0; 
		queue.offer(a); 
		
		while(!queue.isEmpty()) { 
			int x = queue.poll();
			if(check[k]!=0) break; 
								  
			if((x-1>=0) && check[x-1]==0) { 
				queue.offer(x-1);  			
				check[x-1] = check[x]+1; 
			}
			if((x<check.length-1)&&check[x+1]==0) {
				queue.offer(x+1);
				check[x+1] = check[x]+1; 
			}
			if((x*2<check.length)&&check[2*x]==0) {
				queue.offer(2*x);
				check[2*x] = check[x]+1;
			}
			
		}	
	}
	
}