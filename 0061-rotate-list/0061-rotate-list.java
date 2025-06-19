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

        k=k%l;
        if(k==0){
            return head;
        }
        for(int i = 0; i<k;i++){
            ListNode prev = null;
            ListNode last = head;

            while(last.next != null){
                prev = last;
                last = last.next;
            }
            prev.next = null;
            last.next = head;
            head = last;
        }
        return head;
    }
}