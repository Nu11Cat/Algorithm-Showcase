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
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }
    private ListNode sortList(ListNode tou,ListNode wei){
        if(tou == null) return tou;
        if(tou.next == wei){
            tou.next = null;
            return tou;
        }
        ListNode slow = tou ,fast = tou;
        while(fast!=wei){
            slow = slow.next;
            fast = fast.next;
            if(fast != wei) fast = fast.next;
        }
        ListNode qian = sortList(tou,slow);
        ListNode hou = sortList(slow,wei);
        ListNode ed = pinjie(qian,hou);
        return ed;
    }
    private ListNode pinjie(ListNode head1,ListNode head2){
        ListNode prummy = new ListNode(0);
        ListNode temp = prummy,temp1=head1,temp2=head2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next = temp1;
                temp1=temp1.next;
                temp=temp.next;
            }else {
                temp.next = temp2;
                temp2=temp2.next;
                temp=temp.next;
            }
        }
        if(temp1!=null) temp.next = temp1;
        if(temp2!=null) temp.next = temp2;
        return prummy.next;
    }
}