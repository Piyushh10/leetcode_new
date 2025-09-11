class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        int ans = 0;
        for(int num : hs){
            if(!hs.contains(num-1)){
                int currNum = num;
                int currAns = 1;
                while(hs.contains(currNum+1)){
                    currAns++;
                    currNum++;
                }
                ans=Math.max(ans, currAns);
            }
        }
        return ans;
    }
}