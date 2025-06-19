/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }
        ListNode a = head;
        int l = 1;
        while(a.next != null){
            a = a.next;
            l++;
        }
        a.next = head;
        k = k%l;
        k = l - k;
        while(k-- > 0){
            a = a.next;
        }
        head = a.next;
        a.next = null;
        return head;
    }
}