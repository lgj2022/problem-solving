import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int map [][] ;
   
    public static int solution(int n, int[][] wires) {
        int answer = 987654321;
        //하나의 요소씩 빼고 돌려보기
        for(int t =0; t<wires.length ; t++){

            map = new int [n+1][n+1];
            //map 정보 받아오기
            for(int e = 0; e<wires.length; e++){
                if(e==t){
                    continue;
                }
                map[wires[e][0]][wires[e][1]]=1;
                map[wires[e][1]][wires[e][0]]=1;
            }
            //bfs 시작
            boolean [] visit = new boolean[n+1];
            int first = bfs(1,visit);
            //System.out.println(first);
            int second =0;
            for (int i =1; i<n+1; i++){
                if(!visit[i]){
                    second=bfs(i,visit);
                }
            }

            answer= Math.min(answer,Math.abs(first-second));


        }

        return answer;
    }

    private static int bfs(int start, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        visit[start]=true;
        queue.add(start);
        int cnt =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            //System.out.println(queue.toString());
            for (int s = 0; s<size; s++) {

                int current = queue.poll();
                for (int i = 1; i < map[0].length; i++) {
                    if (!visit[i] && map[current][i] == 1) {
                        visit[i]=true;
                        queue.add(i);
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }

}