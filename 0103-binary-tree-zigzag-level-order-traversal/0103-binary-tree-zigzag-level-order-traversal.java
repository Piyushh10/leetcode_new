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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        boolean leftToRight = true;
        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            List<Integer> row = new ArrayList<>(size); 
            for (int i = 0; i < size; i++) {
                TreeNode node = nodesQueue.poll();
                if (leftToRight) {
                    row.add(node.val); 
                } else {
                    row.add(0, node.val); 
                }
                if (node.left != null) {
                    nodesQueue.add(node.left);
                }
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(row);
        }
        return result;
    }
}