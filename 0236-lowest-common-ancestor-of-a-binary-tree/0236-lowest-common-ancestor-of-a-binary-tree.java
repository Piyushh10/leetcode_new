/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList <TreeNode> pa = new ArrayList<>();
        findAns(root, p, pa);
        ArrayList <TreeNode> qa = new ArrayList<>();
        findAns(root, q, qa);
        TreeNode res = null;
        for(int i = 0; i<Math.min(pa.size(), qa.size()); i++){
            if(pa.get(i) != qa.get(i)){
                break;
            }
            else{
                res = pa.get(i);
            }
        }
        return res;
    }
    public boolean findAns(TreeNode root, TreeNode target, ArrayList <TreeNode> ans){
        if(root == null){
            return false;
        }
        ans.add(root);
        if(root == target){
            return true;
        }
        if(findAns(root.left, target, ans) || findAns(root.right, target, ans)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
}

// 35
// 3524