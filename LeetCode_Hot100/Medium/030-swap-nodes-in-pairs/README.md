# [24. 两两交换链表中的节点] 
## (https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 递归 | 链表


### 问题描述
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

### 解法分析（详细注释见Java文件）
### 方法1 迭代


**时间复杂度**: O(n)
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
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode todo = result;
        while(todo.next != null && todo.next.next != null){
            ListNode fast = todo.next.next;
            ListNode slow = todo.next;
            todo.next = fast;
            slow.next = fast.next;
            fast.next = slow;
            todo = slow;
        }
        return result.next;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
