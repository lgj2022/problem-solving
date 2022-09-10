class Solution {
    static int max=-1;
    public static int solution(int k, int[][] dungeons) {

        //순서가 중요하다 이건 순열
        int sel[] = new int[dungeons.length];
        boolean visit[] = new boolean[dungeons.length];

        dfs(k,dungeons,sel,visit,0);
        return max;
    }

    private static void dfs(int k, int[][] dungeons, int[] sel,boolean visit[],int cnt) {
        if(cnt==dungeons.length){
            int ans=0;
            int currenthp = k;
            for (int i =0; i<sel.length; i++){
                if(currenthp>=dungeons[sel[i]][0]){
                    currenthp=currenthp-dungeons[sel[i]][1];
                    ans++;
                }
            }
            max=Math.max(max,ans);
        }
        for (int i =0; i<dungeons.length; i++){
            if(!visit[i]){
                visit[i]=true;
                sel[cnt]=i;
                dfs(k,dungeons,sel,visit,cnt+1);
                visit[i]=false;
            }
        }
    }
}