class Solution {
    public int minimumOperations(int[] nums) {
        int[] arr=new int[101];
        for(int i=nums.length-1;i>=0;i--){
            if(arr[nums[i]]!=0){
                if((i+1)%3==0) return (i+1)/3;
                else return (i/3)+1;
            }else{
                arr[nums[i]]=nums[i];
            }
        }

        return 0;
    }
}