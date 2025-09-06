class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        for(int  e : nums){
            pq.offer(e);
            if(pq.size() > k){
                pq.poll();
            }
        }
        this.k=k;
    }
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */