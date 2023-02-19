
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        String move = "";
        
        for(int i=0; i<len; i++){
            s = s.substring(1,len)+s.substring(0,1);
            if(check(s))
                answer++;
            
        }
        return answer;
    }boolean check (String newS){
        Stack<Character> s = new Stack<Character>();
        int len = newS.length();
        for(int i=0; i<len; i++){
            if(newS.charAt(i) == '(')
                s.push(newS.charAt(i));
            else if(newS.charAt(i) == '[')
                s.push(newS.charAt(i));
            else if(newS.charAt(i) == '{')
                s.push(newS.charAt(i));          
            else if(newS.charAt(i) == ')'){
                if(s.empty())
                    return false;
                if(s.peek() != '(')
                    return false;
                s.pop();
            }
            else if(newS.charAt(i) == ']'){
                if(s.empty())
                    return false;
                if(s.peek() != '[')
                    return false;
                s.pop();
            }
            else if(newS.charAt(i) == '}'){
                if(s.empty())
                    return false;
                if(s.peek() != '{')
                    return false;
                s.pop();
            }
                
        }
        if(!s.empty())
            return false;
        return true;
    }
}