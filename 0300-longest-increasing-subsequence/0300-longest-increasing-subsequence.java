class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for(int i = 0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[prev]+1, dp[i]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}