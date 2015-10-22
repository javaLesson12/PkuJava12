/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode delNode = node;
        ListNode nxtNode = node.next;
        ListNode trdNode = node.next.next;
        delNode.val=nxtNode.val;
        delNode.next=trdNode;
    }
}