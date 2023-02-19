class Solution {
       public long solution(int n) {
      int[] d = new int[2001];
      d[1] = 1;
      d[2] = 2;
      d[3] = 3;
     for(int i=4;i<2001; i++){
          d[i] = (d[i-2] + d[i-1]) % 1234567;
      }
      return d[n];
  }
}