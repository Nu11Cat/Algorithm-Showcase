/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Map<Node,Node>map = new HashMap<>();
        Node ne = head;
        while(ne!=null){
            map.put(ne,new Node(ne.val));
            ne=ne.next;
        }
        ne = head;
        while(ne!=null){
            Node temp = map.get(ne);
            temp.next = map.get(ne.next);
            temp.random = map.get(ne.random);
            ne = ne.next;
        }
        return map.get(head);
    }
}