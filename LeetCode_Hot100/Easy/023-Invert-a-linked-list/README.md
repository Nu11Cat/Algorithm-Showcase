# [206. 反转链表] 
## (https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 递归 | 链表


### 问题描述
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

### 解法分析（详细注释见Java文件）
### 方法1 双指针


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
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
