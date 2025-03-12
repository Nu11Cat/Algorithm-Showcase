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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = null;
        for(int i=0;i<lists.length;i++){
            temp = mergeList(temp,lists[i]);
        }
        return temp;
    }
    private ListNode mergeList(ListNode head1 , ListNode head2){
        ListNode prummy = new ListNode(0);
        ListNode temp = prummy,temp1=head1,temp2=head2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next = temp1;
                temp=temp.next;
                temp1=temp1.next;
            }else{
                temp.next = temp2;
                temp=temp.next;
                temp2=temp2.next;
            }
        }
        if(temp1!=null) temp.next = temp1;
        if(temp2!=null) temp.next = temp2;
        return prummy.next;
    }
}