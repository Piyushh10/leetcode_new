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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        traverse(root, set);
        
        Iterator<Integer> it = set.iterator();
        int count = 1;
        while (it.hasNext()) {
            int val = it.next();
            if (count == k) return val;
            count++;
        }
        return -1;
    }
    
    private void traverse(TreeNode node, TreeSet<Integer> set) {
        if (node == null) return;
        set.add(node.val);
        traverse(node.left, set);
        traverse(node.right, set);
    }
}