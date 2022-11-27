
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int [1001];
        int num[] ={1,5,10,50};
        check(0,num,arr,n,0);
        System.out.println(answer);
    }
    static void check(int current, int[] num, int[] arr, int n,int idx){
        if(n==0){
            if(arr[current]==1) {
            }
            else{
                arr[current]=1;
                answer++;
            }
            return;
        }
        for(int i=idx ; i<num.length;i++){
            check(current+num[i],num,arr,n-1,i);
        }
    }
}
