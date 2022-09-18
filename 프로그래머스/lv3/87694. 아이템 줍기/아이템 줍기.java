

import java.util.*;

public class Solution {
    static int[] dc = {0, 1, 0, -1};
    static int[] dr = {-1, 0, 1, 0};
    static int [][] map;
    static boolean[][] visited;
    static int distance = Integer.MAX_VALUE;

    
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[0].length; j++) {
                rectangle[i][j] = rectangle[i][j] * 2;
            }
        }
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for (int[] point : rectangle) {
            int lx = point[0];
            int ly = point[1];
            int rx = point[2];
            int ry = point[3];
            maxX = Math.max(maxX, rx);
            maxY = Math.max(maxY, ry);
        }
        visited = new boolean[maxY + 1][maxX + 1];
        map = new int[maxY + 1][maxX + 1];
        
        for (int [] point : rectangle){
            fillrectangle(point);
        }
        for (int[] point : rectangle){
            removeinside(point);
        }
        //bfs
        getDistance(characterX,characterY,itemX,itemY);

        
        return distance/2;
    }

    private static void removeinside(int[] point) {
        for (int i =point[1]+1; i<point[3]; i++){
            for (int j= point[0]+1; j<point[2]; j++){
                map[i][j]=0;
            }
        }
    }

    private static void getDistance(int characterX, int characterY, int itemX, int itemY) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int []{characterY,characterX,0});
        visited[characterY][characterX]=true;
        while (!queue.isEmpty()){
            int current[] = queue.poll();
            int currentrow = current[0];
            int currentcol = current[1];
            int count = current[2];
            //System.out.println(currentcol+" "+currentrow+" "+count);
            if(currentcol==itemX && currentrow==itemY){
                distance = Math.min(count,distance);
                break;
            }
            for (int i =0; i<4; i++){
                int ncol = currentcol+dc[i];
                int nrow = currentrow+dr[i];
                if(nrow>=0 && nrow<map.length && ncol>=0 && ncol<map[0].length && map[nrow][ncol]==1&&!visited[nrow][ncol]){
                    visited[nrow][ncol]=true;
                    queue.add(new int[]{nrow,ncol,count+1});
                }
            }
        }
    }
    //{1,1,7,4}
    private static void fillrectangle(int [] point) {
        for (int i =point[1]; i<=point[3]; i++){
            for (int j= point[0]; j<=point[2]; j++){

                map[i][j]=1;
            }
        }
    }

}
