/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node a = head;
        while(a!=null){
            Node copy = new Node(a.val);
            hm.put(a, copy);
            a=a.next;
        }
        a = head;
        hm.put(null, null);
        while(a!=null){
            Node copyy = hm.get(a);
            copyy.next = hm.get(a.next);
            copyy.random = hm.get(a.random);
            a=a.next;

        }
        return hm.get(head);
    }
}