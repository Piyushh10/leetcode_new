class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 2;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(mid%2==0){
                if(nums[mid] == nums[mid+1]){
                    l = mid + 1;
                } else{
                    r = mid - 1;
                }
            } else{
                if(nums[mid] == nums[mid-1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return nums[l];
    }
}