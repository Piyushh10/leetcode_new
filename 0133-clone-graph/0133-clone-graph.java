/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node, Node> hm = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return ansFinder(node);
    }
    
    public Node ansFinder(Node node){
        if(hm.containsKey(node)){
            return hm.get(node);
        }

        Node ans = new Node(node.val);
        hm.put(node, ans);

        for(Node padosi : node.neighbors){
            ans.neighbors.add(ansFinder(padosi));
        }
        return ans;
    }
}