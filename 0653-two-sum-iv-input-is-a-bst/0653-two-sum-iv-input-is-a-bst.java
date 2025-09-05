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
    ArrayList<Integer> al = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        lister(root);
        int l = 0, r = al.size() - 1;
        while (l < r) {
            int sum = al.get(l) + al.get(r);
            if (sum == k) return true;
            if (sum < k) l++;
            else r--;
        }
        return false;
    }
    public void lister(TreeNode root){
        if(root == null) return;
        lister(root.left);
        al.add(root.val);
        lister(root.right);
    }
}