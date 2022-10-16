class Solution {
   public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char max;
        int idx = 0;
        if(number.charAt(0)=='0')
            return "0";
        for(int i = 0; i<number.length()-k; i++) {
            max = '0';
            for(int j = idx; j<=k+i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j+1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}