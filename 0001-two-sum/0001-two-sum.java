class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int a = nums[i];
            int req = target - a;
            if(map.containsKey(req)){
                return new int[]{map.get(req), i};
            }
            map.put(a, i);
        }
        return new int[]{-1, -1};
    }
}
