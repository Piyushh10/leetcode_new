/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null ||headB == null){
            return null;
        }
        int lenA = getl(headA);
        int lenB = getl(headB);

        ListNode a = headA;
        ListNode b = headB;

        if(lenA > lenB){
            for(int i = 0; i<lenA-lenB;i++){
                a = a.next;
            }
        }else{
            for(int i = 0; i<lenB-lenA;i++){
                b=b.next;
            }
        }
        while(a != null && b!=null){
            if(a==b){
                return a;
            }else{
                a=a.next;
                b=b.next;
            }
        }
        return null;
    }
    private int getl(ListNode node){
        int l = 0;
        while(node != null){
            l++;
            node=node.next;
        }
        return l;
    }
}