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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0, head);
        ListNode curr = result, iter = head;
        for (int i = 0; i < n; i++) {
            iter = iter.next;
        }
        while (iter != null) {
            curr = curr.next;
            iter = iter.next;
        }
        curr.next = curr.next.next;
        return result.next;
    }
}