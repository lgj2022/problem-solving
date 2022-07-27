import java.util.*;
class Solution {
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,1,-1};
    static char[][] map;
    static boolean [][] visit;
    static int flag = 0;
    public int[] solution(String[][] places) {

        int[] answer = new int [5];
        
        for(int i =0; i<places.length ; i++){
            map = new char [5][5];
            ArrayList<int[]> al = new ArrayList<>();
            for(int j=0; j<places[i].length; j++){
                for(int z= 0; z<places[i][j].length(); z++){
                   map[j][z]=places[i][j].charAt(z);
                    if(map[j][z]=='P'){
                        al.add(new int [] {j,z});
                    }
                }
            }
            
            /*
            for(char[] tmp : map){
                System.out.println(Arrays.toString(tmp));
            }*/
            flag = 0;
            for(int k =0; k< al.size(); k++){
                visit = new boolean [5][5];
                visit[al.get(k)[0]][al.get(k)[1]]=true;
                System.out.println("시작 로우"+ al.get(k)[0]+"시작 컬럼"+al.get(k)[1]);
                //check(al.get(k)[0],al.get(k)[1],visit,0,0);
                bfs(al.get(k),visit);
            }
            
            if(flag==1){
                answer[i]=0;
            }
            else{
                answer[i]=1;
            }
        }
        
        
        return answer;
    }

    
    void check(int row, int col , boolean [][] visit, int dist, int chk){
        if(row==0){
                System.out.println("row "+row+"col "+col+"dist "+dist);
                }
        if(map[row][col]=='P' && dist==1 ){
            System.out.println(row+" "+col);
            flag=1;
            return;
        }
        if(map[row][col]=='P' && dist==2 && chk==1){
            //System.out.println(row+" "+col);
            flag=1;
            return;
        }
        if(flag==1){
            return;
        }
        
        for(int i =0 ; i<4; i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            
            if(nrow >= 0 && nrow<5 && ncol>=0 && ncol<5 && map[nrow][ncol]!='X' && !visit[nrow][ncol]){
                if(nrow==0){
                System.out.println("nrow "+nrow+"ncol "+ncol);
                }
                visit[nrow][ncol]=true;
                if(map[nrow][ncol]=='O'){
                    chk=1;
                }
                check(nrow,ncol,visit,dist+1,chk);
            }
        }
    }
    
    
    void bfs(int [] current , boolean visit[][]){
        Queue <int []> que = new LinkedList<>();

        que.add(new int[] {current[0],current[1],0,0});
        
        while(!que.isEmpty()){
            int tmp[] =que.poll();        
            int row = tmp[0];
            int col = tmp[1];
            int dist = tmp[2];
            int chk= tmp[3];
            
            if(map[row][col]=='P' && dist==1 ){
            System.out.println(row+" "+col);
            flag=1;
            break;
        }
        if(map[row][col]=='P' && dist==2 && chk==1){
            //System.out.println(row+" "+col);
            flag=1;
            break;
        }
       
            
         for(int i =0 ; i<4; i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            
            if(nrow >= 0 && nrow<5 && ncol>=0 && ncol<5 && map[nrow][ncol]!='X' && !visit[nrow][ncol]){
                if(nrow==0){
                System.out.println("nrow "+nrow+"ncol "+ncol);
                }
                visit[nrow][ncol]=true;
                if(map[nrow][ncol]=='O'){
                    chk=1;
                }
                que.add(new int [] {nrow,ncol,dist+1,chk});
            }
         }
            
        }
    }
}