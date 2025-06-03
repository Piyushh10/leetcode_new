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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length){
            return null;
        }
        int n = inorder.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(inorder[i], i);
        }
        return treeBanaao(inorder, 0, n-1, postorder, 0, postorder.length-1, hm);
    }

    private TreeNode treeBanaao(int[]inorder, int is, int ie, int[]postorder, int ps, int pe, HashMap<Integer, Integer> hm){

        if(ps>pe || is>ie) return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = hm.get(postorder[pe]);
        int numsOnLeft = inRoot - is;
        root.left = treeBanaao(inorder, is, inRoot-1, postorder, ps, ps+numsOnLeft-1, hm);
        root.right = treeBanaao(inorder, inRoot+1, ie, postorder, ps+numsOnLeft, pe-1, hm);
        return root;
    }
}