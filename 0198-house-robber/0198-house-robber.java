class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev2 = nums[0];
        if(n==1){
            return nums[0];
        }
        int prev1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i<n; i++){
        int take = (i>1) ? nums[i] + prev2 : nums[i];
        int nottake = prev1;
        int curri = Math.max(take, nottake);
        prev2 = prev1;
        prev1 = curri;
        }
        return prev1;
    }
}

//space optimization