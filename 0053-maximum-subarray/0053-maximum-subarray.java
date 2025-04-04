class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            if(currSum>maxSum){
                maxSum = currSum;
            }
            if(currSum<0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}

//Kadane's Algorithm