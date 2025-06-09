class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low=0, mid=0, high = n-1;
        while(mid<=high){
            if(nums[mid] == 0){
                swap(low, mid, nums);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(mid, high, nums);
                high--;
            }
        }
    }
    public void swap(int a, int b,int nums[]){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}