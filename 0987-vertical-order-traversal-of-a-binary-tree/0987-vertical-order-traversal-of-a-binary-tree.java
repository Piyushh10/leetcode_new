/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair<K, V>{
    private K key;
    private V value;
    Pair(K key, V value){
        this.key = key;
        this.value=value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
 }

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> hm = new TreeMap<>();

        Queue<Pair<TreeNode, Pair<Integer, Integer>>> q = new LinkedList<>();
        q.add(new Pair<>(root, new Pair<>(0,0)));

        while(!q.isEmpty()){
            Pair<TreeNode, Pair<Integer, Integer>> pair = q.poll();
            TreeNode temp = pair.getKey();
            int hd = pair.getValue().getKey();
            int level = pair.getValue().getValue();

            if(!hm.containsKey(hd)) {
                hm.put(hd, new TreeMap<>());
            }
            if(!hm.get(hd).containsKey(level)) {
                hm.get(hd).put(level, new PriorityQueue<>());
            }

            hm.get(hd).get(level).add(temp.val);

            if(temp.left != null){
                q.add(new Pair<>(temp.left, new Pair<>(hd-1, level+1)));
            }
            
            if(temp.right != null){
                q.add(new Pair<>(temp.right, new Pair<>(hd+1, level+1)));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> levels : hm.values()) {
            List<Integer> verticalLevel = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : levels.values()) {
                while(!nodes.isEmpty()) {
                    verticalLevel.add(nodes.poll());
                }
            }
            ans.add(verticalLevel);
        }
        return ans;
    }
}