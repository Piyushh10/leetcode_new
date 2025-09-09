class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(n==0 || m==0){
            return Math.max(n, m);
        }
        if(word1.equals(word2)){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<=m;i++){
            dp[i][0] = i;
        }
        for(int i = 1; i<=n;i++){
            dp[0][i] = i;
        }

        for(int i = 1; i<=m;i++){
            for(int j = 1; j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = min(
                        dp[i-1][j] + 1,
                        dp[i][j-1]+1,
                        dp[i-1][j-1]+1
                        );
                }
            }
        }
        return dp[m][n];
    }
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
}