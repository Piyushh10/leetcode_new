class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    
    public MedianFinder() {
        this.left = new PriorityQueue<>(Collections.reverseOrder()); //maxheap
        this.right = new PriorityQueue<>(); //minheap
    }
    
    public void addNum(int num) {
        if(left.size()==right.size()){
            right.add(num);
            left.add(right.remove());
        }else{
            left.add(num);
            right.add(left.remove());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek()+right.peek())/2.0;
        }else{
            return left.peek()*1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */