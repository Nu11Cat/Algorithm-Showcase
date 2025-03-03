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
        ListNode result = head;
        ListNode fast = head;
        ListNode slow = head;
        int ready = 0;
        ListNode slowqian = null;
        while(fast != null){
            if(ready++>=n){
                slowqian=slow;
                slow=slow.next;
            }
            fast=fast.next;
        }
        if(slowqian != null){
            slowqian.next=slow.next;
            slow.next = null;
        }else {
            result = result.next;
        }
        return result;
    }
}