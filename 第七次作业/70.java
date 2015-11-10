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
    if(head==null || head.next==null) 
        return head;
    ListNode tail = head;
    ListNode cur = head.next;
    while(cur!=null){
        if(cur.val==tail.val){
            
            tail.next = cur.next;
            cur = cur.next;
        }else{
            tail=cur;
            cur =cur.next;
        }
    }
    return head;        
    }
}