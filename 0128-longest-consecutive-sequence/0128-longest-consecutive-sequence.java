class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int currmax=1;
        int max = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    currmax++;
                }else{
                    max=Math.max(max,currmax);
                    currmax=1;
                }
            }
        }
        return Math.max(currmax, max);
    }
}