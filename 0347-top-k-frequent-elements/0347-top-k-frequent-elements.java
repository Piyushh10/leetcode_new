class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b) -> a.freq - b.freq);
        int [] res = new int[k];

        for(int j : hm.keySet()){
            int fr = hm.get(j);
            if(pq.size() < k){
                pq.add(new Node(j, fr));
            }else{
                if(pq.peek().freq < fr){
                    pq.remove();
                    pq.add(new Node(j, fr));
                }
            }
        }
        int l = 0;
        while(!pq.isEmpty()){
            Node value = pq.remove();
            res[l] = value.val;
            l++;
        }
        return res;
    }
}
class Node{
    int val;
    int freq;
    Node(int val, int freq){
        this.freq = freq;
        this.val = val;
    }
}