/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p =head;
        while (p!=null){
            ListNode pnext= p.next;
            if (p.next==null){
               break;
            }
            if(pnext.val==p.val){
                p.next=pnext.next;
            }else {
                p=pnext;
            }
        }
        return head;
    }
}