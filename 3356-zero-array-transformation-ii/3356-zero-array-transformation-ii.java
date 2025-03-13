class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length,sum=0,k=0;
        int[] da=new int[n+1];
        for(int i=0;i<n;i++){
            while(sum+da[i]<nums[i]){
                k++;
                if(k>queries.length){
                    return -1;
                }
                int left=queries[k-1][0];
                int right=queries[k-1][1];
                int val=queries[k-1][2];
                if(right>=i){
                    da[Math.max(left,i)]+=val;
                    da[right+1]-=val;
                }
            }
            sum+=da[i];
        }
        return k;
    }
}