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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode up = list1,down = list2;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while(up != null && down !=null){
            if(up.val>down.val){
                result.next=down;
                down=down.next;
            }
            else {
                result.next=up;
                up=up.next;
            }
            result=result.next;
        }
        if(down != null) result.next = down;
        if(up != null) result.next = up;
        return dummy.next;
    }
}