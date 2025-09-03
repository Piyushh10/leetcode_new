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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            hm.put(inorder[i], i);
        }
        TreeNode ans = helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, hm);
        return ans;
    }
    public TreeNode helper(int [] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> hm){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootInd = hm.get(root.val);
        int onLeft = rootInd - inStart;

        root.left = helper(preorder, preStart + 1, preStart + onLeft, inorder, inStart, rootInd - 1, hm);
        root.right = helper(preorder, preStart + onLeft + 1, preEnd, inorder, rootInd + 1, inEnd, hm);

        return root;
        
    }
}