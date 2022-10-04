
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean flag=true;
        while(flag){
            StringTokenizer  st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0){
                flag=false;
                break;
            }
            else{
                int arr[] = new int [n];
                for (int i=0; i<n; i++){
                    arr[i]= Integer.parseInt(st.nextToken());
                }
                boolean visit[] = new boolean[arr.length];
                permutation(arr,new int[6],0,visit,0);
                //System.out.println("Arrays.toString(tmp) = " + Arrays.toString(tmp));
            }

            System.out.println();
        }
    }

    private static void permutation(int[] arr, int[] current, int count, boolean[] visit,int start) {
        //System.out.println("Arrays.toString(current)+\" \"+count = " + Arrays.toString(current)+" "+count);
        if(count==6){
            for (int i =0; i<current.length; i++){
                System.out.print(current[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i=start; i<arr.length; i++){
            current[count]=arr[i];
            visit[i]=true;
            permutation(arr,current,count+1, visit,i+1);
            current[count]=0;
            visit[i]=false;
        }

    }
}
