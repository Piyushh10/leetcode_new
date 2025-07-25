class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 2]; 
        dp[n] = 1; 
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0; 
            } else {
                dp[i] = dp[i + 1]; 
                if (i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) != -1))) {
                    dp[i] += dp[i + 2]; 
                }
            }
        }
        return dp[0];
    }
}
