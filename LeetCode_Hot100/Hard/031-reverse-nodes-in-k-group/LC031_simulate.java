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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prummy = new ListNode(0);
        prummy.next = head;

        ListNode tou = head;
        ListNode touqian = prummy;
        while(tou!=null){
            ListNode n=touqian;
            for(int i=0;i<k;i++){
                n=n.next;
                if(n==null) return prummy.next;
            }
                ListNode nnext=n.next;
                ListNode[] zhong = swqp(tou,n);
                tou = zhong[0];
                n = zhong[1];
                touqian.next=tou;
                n.next=nnext;
                touqian=n;
                tou=n.next;
        }
        return prummy.next;
    }
    private ListNode[] swqp(ListNode tou,ListNode wei){
        ListNode next = tou;
        ListNode result = wei.next;
        while(result != wei){
            ListNode temp = next.next;
            next.next = result;
            result = next;
            next = temp;
        }
        return new ListNode[]{wei,tou};
    }
}