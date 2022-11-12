class Solution {
   public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length + 1];
        dp[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
        }
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 1; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        int answer = 0;
        for(int value : dp[triangle.length-1]) {
            answer = Math.max(answer, value);
        }
        return answer;
    }
}