
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int t;
    static int [][]map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        StringTokenizer st =new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(bf.readLine());
        map  = new int [t+1][t+1];
        for (int i=0; i<k; i++){
            st =new StringTokenizer(bf.readLine());
            int tm1 =Integer.parseInt(st.nextToken());
            int tm2 =Integer.parseInt(st.nextToken());
            map[tm1][tm2]=1;
            map[tm2][tm1]=1;
        }
        int ans = startbfs(m,n);
        System.out.println(ans);
    }

    private static int startbfs(int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean visit [][] = new boolean[t+1][t+1];
        queue.add(new int[] {0,m,0});
        while (!queue.isEmpty()){
            int current[] = queue.poll();
            if(current[0]==n){
                return current[2]-1;
            }
            for (int i =1; i<=t; i++){
                if(map[current[1]][i]==1 && !visit[current[1]][i]){
                    visit[current[1]][i]=true;
                    queue.add(new int[] {current[1],i,current[2]+1});
                }
            }
        }
        return  -1;
    }
}
