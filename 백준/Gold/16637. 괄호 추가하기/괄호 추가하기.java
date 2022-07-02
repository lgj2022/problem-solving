import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int size;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//연산자 우선순위가 동일하다
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		int n  = Integer.parseInt(bf.readLine());
		String s = bf.readLine();
		ArrayList<Integer> nl = new ArrayList<>();
		ArrayList<Character>cl = new ArrayList<>();
		for(int i =0; i< s.length(); i++) {
			if(i%2==0) {
				nl.add(s.charAt(i)-'0');
			}
			else {
				cl.add(s.charAt(i));
			}
		}
		size = nl.size();
		ans =-987654321;
		dfs(0,1,nl,cl);
		dfs(0,0,nl,cl);
		System.out.println(ans);
	}

	private static void dfs(int current, int flag, ArrayList<Integer> nl, ArrayList<Character> cl) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numlist = new ArrayList<>();
		ArrayList<Character> operlist = new ArrayList<>();
		numlist.addAll(nl);
		operlist.addAll(cl);
		
		if(current==nl.size()-1) {
			while(numlist.size()>1) {
				cal(numlist,operlist,0);
			}
			ans  = Math.max(ans, numlist.get(0));
			return;
		}
		if(flag==1) {
			cal(nl,cl,current);
		}
		
		dfs(current+1,1,numlist,operlist);
		dfs(current+1,0,numlist,operlist);
		
	}
	
	public static void cal(ArrayList<Integer> nl, ArrayList<Character> cl, int idx) {
        char oper = cl.remove(idx);
        int num1 = nl.remove(idx);
        int num2 = nl.remove(idx);
        if(oper == '+') {
            nl.add(idx, num1 + num2);
        }
        else if(oper == '-') {
            nl.add(idx, num1 - num2);
        }
        else if(oper == '*') {
            nl.add(idx, num1 * num2);
        }
    }
}
