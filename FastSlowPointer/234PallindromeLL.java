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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverse = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = temp;
        }
        fast = head;
        while (reverse != null && fast != null) {
            if (reverse.val == fast.val) {
                reverse = reverse.next;
                fast = fast.next;
            } else return false;  
        }
        return true;
    }
}