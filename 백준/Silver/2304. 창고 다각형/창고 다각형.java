import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int minwidth = 1001;
    static int maxwidth  = 0;
    static int maxheight = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int arr[] = new int [1001];
        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            minwidth = Math.min(minwidth,width);
            maxheight = Math.max(maxheight,height);
            maxwidth = Math.max(maxwidth,width);

            arr [width] = height;
        }

        int ans = 0;
        int endpoint =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(-arr[minwidth]);
        for(int i =minwidth ; i<= maxwidth ; i++){
            if(arr[i] == maxheight){
                ans = ans +maxheight;
                endpoint =i;
                break;
            }
            if(arr[i]!=0) {
                pq.add(-arr[i]);
            }
            ans = ans + (pq.peek() * -1);
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.add(arr[maxwidth]);
        for(int i= maxwidth ; i> endpoint ; i--){
            if(arr[i]!=0) {
                pq1.add(-arr[i]);
            }
            ans = ans + pq1.peek() * -1;

        }
        System.out.println(ans);

    }
}
