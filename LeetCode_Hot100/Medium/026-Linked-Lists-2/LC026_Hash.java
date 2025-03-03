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
        Map<ListNode,Integer> map = new HashMap<>();
        ListNode code = head;
        while(code!=null){
            if(map.containsKey(code)){
                return code;
            }
            else map.put(code,1);
            code=code.next;
        }
        return null;
    }
}