import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int [commands.length];
        //r
        for(int i =0; i<commands.length; i++){
            int tmp[] = commands[i];
            int a[] = new int [tmp[1]-tmp[0]+1];
            
            for(int j=0; j<a.length; j++){
                a[j]=array[tmp[0]+j-1];
            }
            Arrays.sort(a);
            answer[i]=a[tmp[2]-1];
        }
        return answer;
    }
}