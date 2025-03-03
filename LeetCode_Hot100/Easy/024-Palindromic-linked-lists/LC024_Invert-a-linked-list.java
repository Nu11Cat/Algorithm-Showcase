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
        ListNode fast=head,slow = head;
        ListNode pre = null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            ListNode temp = slow.next;
            slow.next=pre;
            pre=slow;
            slow=temp;
        }
        if(fast != null) slow=slow.next;
        while(slow !=null && pre != null){
            if(slow.val != pre.val) return false;
            slow=slow.next;
            pre=pre.next;
        }
        return true;
    }
}