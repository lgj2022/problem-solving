import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();    
        
        for(String tmp : completion){
            int cnt =1;
            if(map.containsKey(tmp)){
                cnt=map.get(tmp)+1;
            }
            map.put(tmp,cnt);
        }
        
        
        for(String tmp : participant){
            if(map.containsKey(tmp)){
                int cnt = map.get(tmp)-1;
                //System.out.print(tmp+" "+cnt);
                
                if(cnt<0){
                    answer =tmp;
                    break;
                }
                else{
                    map.put(tmp,cnt);
                }
            }
            else{
                answer =tmp;
                break;
            }
        }
        
        
        return answer;
    }
}