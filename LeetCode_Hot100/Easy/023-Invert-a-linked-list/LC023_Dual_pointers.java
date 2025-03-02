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
    public ListNode reverseList(ListNode head) {
        ListNode next = head;
        ListNode result = null;
        while(next != null){
            ListNode temp=next.next;
            next.next=result;
            result = next;
            next=temp;
        }
        return result;
    }
}