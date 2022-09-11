class Solution {
   static char[] aeiou = {'A','E','I','O','U'};
    static int count = 0;
    static boolean isStop = false;

    public static int solution(String word) {
        dfs(0, "", word);
        return count;
    }

    public static void dfs(int depth, String next, String target) {
       
        if (depth == 6) {

            return;
        }

        if (next.equals(target)) {
            isStop = true;
            return;
        }

        for (int i=0; i<5; i++) {
            if (isStop) return;

            if(depth + 1 < 6) count++;
            dfs(depth + 1, next + aeiou[i], target);
        }
    }
}