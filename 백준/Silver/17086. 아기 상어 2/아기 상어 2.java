
import java.io.*;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static int map[][];
    static int dr[] = {-1,1,0,0,1,1,-1,-1};
    static int dc[] = {0,0,-1,1,1,-1,1,-1};
    static int ans = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(bf.readLine());

         r = Integer.parseInt(st.nextToken());
         c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for(int i = 0; i<r; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<c; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }


        for(int i =0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j]==0) {
                    startBfs(i, j);
                }
            }
        }

        //printmap(map);
        System.out.println(ans);
    }

    private static void startBfs(int si, int sj) {
        Queue<int [] > queue = new LinkedList<>();
        queue.add(new int[] {si,sj,0} );
        boolean check[][] = new boolean[r][c];

        while(!queue.isEmpty()){
            int [] current = queue.poll();
            //System.out.println(Arrays.toString(current));
            if(map[current[0]][current[1]]==1){
                ans = Math.max(ans,current[2]);
                return;
            }
            for(int i =0; i<8; i++){
                int nrow = current[0]+dr[i];
                int ncol = current[1]+dc[i];
                if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && !check[nrow][ncol] ){
                    check[nrow][ncol]=true;
                    queue.add(new int[] {nrow,ncol,current[2]+1});
                }
            }
        }
    }

    private static void printmap(int[][] map) {
        for(int [] tmp : map){
            System.out.println(Arrays.toString(tmp));
        }
    }
}
