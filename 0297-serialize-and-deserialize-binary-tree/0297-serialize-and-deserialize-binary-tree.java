/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        bs(root, sb);
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private void bs(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        bs(root.left, sb);
        bs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return bt(nodes);
    }

    private TreeNode bt(Queue<String> nodes){
        String val = nodes.poll();
        if(val == null || val.equals("null")){
            return null;
        }

        TreeNode ab = new TreeNode(Integer.parseInt(val));
        ab.left = bt(nodes);
        ab.right = bt(nodes);
        return ab;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));