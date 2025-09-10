class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int product=1;
        for(int num : nums){
            product *= num;
        }
        for(int i = 0; i<n;i++){
            if(nums[i] == 0){
                ans[i] = findProduct(nums, i);
            }else{
                ans[i] = (int) product/nums[i];
            }
        }
        return ans;
    }
    public int findProduct(int [] nums, int ind){
        int ans = 1;
        for(int i = 0; i<nums.length;i++){
            if(i == ind){
                continue;
            }
            ans *= nums[i];
        }
        return ans;
    }
}