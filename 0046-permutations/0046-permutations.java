class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subans = new ArrayList<>();
        boolean [] freq = new boolean[nums.length];
        int n = nums.length;
        f(nums,ans,subans,freq,n);
        return ans;
    }
    public void f(int[]nums, List<List<Integer>> ans, List<Integer> subans, boolean[]freq, int n){
        if(subans.size() == n){
            ans.add(new ArrayList<>(subans));
            return;
        }
        for(int i = 0; i<n;i++){
            if(!freq[i]){
                freq[i] = true;
                subans.add(nums[i]);
                f(nums,ans,subans,freq,n);
                subans.remove(subans.size()-1);
                freq[i] = false;
            }
        }
    }
}