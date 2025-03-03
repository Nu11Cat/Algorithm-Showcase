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
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node.val);
            node=node.next;
        }
        //System.out.println(list);
        int l = 0 ,r = list.size()-1;
        while(l <= r){
            if(list.get(l)!=list.get(r)) return false;
            l++;r--;
        }
        return true;
    }
}