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
        ListNode temp = head;
        ListNode reversed = null;

        while(temp != null){
            reversed = new ListNode(temp.val, reversed);
            temp = temp.next;
        }

        ListNode a = head;
        ListNode b = reversed;

        while(a != null && b != null){
            if(a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }

        return true;
    }
}