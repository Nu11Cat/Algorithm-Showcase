/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head,slow = head;
        while(fast != null){
            if(fast == null || fast.next == null) return null;
            fast=fast.next.next;
            slow=slow.next;
            if(fast == slow){
                ListNode temp = head;
                while(temp != slow){
                    temp=temp.next;
                    slow=slow.next;
                }
                return temp;
            }
        }
        return null;
        
    }
}