class Solution {
    static int dr[] = {0,1,0,1};
    static int dc[] = {0,0,1,1};
     static public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][]map = new char[m][n];
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board[0].length(); j++){
                map[i][j]=board[i].charAt(j);
            }
        }


        while(true) {
            char[][] tmp = clonemap(map);
            int check = check(tmp, map);

            deletemap(tmp);


            map = clonemap(tmp);

            if(check==0){
                break;
            }
        }

        for(int i =0; i<map.length; i++){
            for(int j =0; j<map[0].length; j++){
                if(map[i][j]=='#'){
                    answer++;
                }
            }
        }
        return answer;
    }

    private static void deletemap(char[][] tmp) {
        for(int c = 0; c<tmp[0].length; c++ ){ // 열 for 문
            for(int r = tmp.length-1; r>=0; r--){
                if(tmp[r][c]=='#'){
                    for(int i =r; i>=0 ; i--){
                        if(tmp[i][c]!='#'){
                            char tmpchar = tmp[r][c];
                            tmp[r][c]=tmp[i][c];
                            tmp[i][c]=tmpchar;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static char[][] clonemap(char[][] map) {
        char[][] tmp = new char[map.length][map[0].length];
        for(int i=0 ; i<map.length;i++){
            for(int j=0; j<map[0].length; j++){
                tmp[i][j]=map[i][j];
            }
        }
        return tmp;
    }

    private static void printmap(char[][] map) {
        for(char[] tmp: map){
            for(char a: tmp){
                System.out.print(a);
            }
            System.out.println();
        }
    }

    private static int check(char[][] tmp,char[][] map) {
        int cnt = 0;
        for(int i =0; i<map.length; i++){
            for(int j =0; j<map[0].length ; j++){
                if(map[i][j]!='#'&&deletecheck(i,j,map)){
                    cnt++;
                    for(int z = 0; z< 4; z++){
                        int nrow = i+dr[z];
                        int ncol = j+dc[z];
                        tmp[nrow][ncol]='#';
                    }
                }
            }
        }
        return cnt;
    }

    private static boolean deletecheck(int r, int c, char[][] map) {


        for(int i =0; i<4 ; i++){
            int nrow = r+dr[i];
            int ncol = c+dc[i];
            if(nrow>=0 && nrow<map.length && ncol>=0 && ncol<map[0].length){
                if(map[r][c]!=map[nrow][ncol]){
                    return false;
                }
            }
            else{
                return false;
            }

        }

        return true;
    }

}