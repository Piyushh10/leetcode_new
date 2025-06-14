class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        Arrays.sort(nums);
        int count = 0;
        int maxc=0;
        for(int i = 0; i<n-1;i++){
            if(nums[i+1] == nums[i] + 1){
                count++;
                maxc = Math.max(maxc, count);
            }else if(nums[i+1] == nums[i]){
                continue;
            }else{
                count = 0;
            }
        }
        return maxc+1;
    }
}