import java.util.*;
 
public class Main {    
 
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        for(int i = 0; i < t; i++) {
            int n = scan.nextInt();
            scan.nextLine();
            
            String[] nums = new String[n];
            for(int j = 0; j < n; j++) {
                nums[j] = scan.nextLine();
            }
            Arrays.sort(nums);
            
            boolean isInclude = true;
            for(int j = 1; j < n; j++) {
                if(nums[j].startsWith(nums[j - 1])) {
                    isInclude = false;
                    break;
                }
            }
            if(isInclude == false) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
