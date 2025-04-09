class Solution {
    public int minOperations(int[] nums, int k) {
    Arrays.sort(nums);
    int prev=-1;
    int ops=0;
    for(int i:nums){
    if(i<k){
        return -1;
    }

    if(prev!=i && i>k){
    ops++;
    prev=i;
    }
    }

    return ops;
    }
}