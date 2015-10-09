/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
//        Stack<Integer> stack = new Stack<>();
//        ListNode p = head;
//        int len = 0;
//        while (p != null) {
//            len++;
//            p = p.next;
//        }
//        int il = len / 2;
//        p = head;
//        while (il-->0) {
//            stack.push(p.val);
//            p = p.next;
//        }
//        System.out.println(p.val);
//        if (len % 2 != 0) {
//            p = p.next;
//        }
//        while (!stack.isEmpty()) {
//            if (p.val != stack.pop())
//                return false;
//            p=p.next;
//        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        ListNode pre;
        p=head;
        int il = len / 2;
        while (il-- > 0) {
            p = p.next;
        }
        if (len % 2 != 0) {
            pre = p;
            p = p.next;
        } else {
            pre = null;
        }

        ListNode next;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        ListNode last = pre;
        ListNode fst = head;
        while (last != null && last != fst) {
            if (fst.val != last.val) {
                return false;
            }
            fst = fst.next;
            last = last.next;

        }
        return true;
    }
}