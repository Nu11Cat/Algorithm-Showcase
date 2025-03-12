# [23. 合并 K 个升序链表] 
## (https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 链表 | 分治 | 堆（优先队列）| 归并排序

### 问题描述
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

### 解法分析（详细注释见Java文件）
### 方法1 顺序合并

**时间复杂度**: O(k^2 n)
**空间复杂度**: O(1)
```java
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
```
### 方法2 分治合并

**时间复杂度**: O(kn×logk)
**空间复杂度**: O(logk) 
```java
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
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
}

```
### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
