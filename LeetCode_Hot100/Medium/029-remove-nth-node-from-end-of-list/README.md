# [19. 删除链表的倒数第 N 个结点] 
## (https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 链表 | 双指针



### 问题描述
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        ListNode fast = head;
        ListNode slow = head;
        int ready = 0;
        ListNode slowqian = null;
        while(fast != null){
            if(ready++>=n){
                slowqian=slow;
                slow=slow.next;
            }
            fast=fast.next;
        }
        if(slowqian != null){
            slowqian.next=slow.next;
            slow.next = null;
        }else {
            result = result.next;
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
