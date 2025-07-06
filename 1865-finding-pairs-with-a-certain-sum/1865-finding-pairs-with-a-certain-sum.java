class FindSumPairs {
    private int [] nums1;
    private int [] nums2;
    private HashMap<Integer, Integer> hm;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.hm = new HashMap<>();
        for(int num : nums2){
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
    }
    
    public void add(int index, int val) {
        int oldVal = nums2[index];
        hm.put(oldVal, hm.get(oldVal)-1);
        if(hm.get(oldVal) == 0){
            hm.remove(oldVal);
        }
        nums2[index]+=val;
        int newVal = nums2[index];
        hm.put(newVal, hm.getOrDefault(newVal, 0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int num : nums1){
            int rem = tot - num;
            count += hm.getOrDefault(rem, 0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
