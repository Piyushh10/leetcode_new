class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>(); 
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Long> hs = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    long sum = (long)nums[i] + nums[j] + nums[k];
                    long remaining = (long)target - sum;
                    
                    if (hs.contains(remaining)) {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], (int)remaining);
                        Collections.sort(quad); 
                        if (!seen.contains(quad)) { 
                            ans.add(quad);
                            seen.add(quad);
                        }
                    }
                    hs.add((long)nums[k]);
                }
            }
        }
        return ans;
    }
}