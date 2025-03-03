# [2. 两数相加] 
## (https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 递归 | 链表 | 数学


### 问题描述
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

### 解法分析（详细注释见Java文件）
### 方法1 模拟

![alt text](image-1.png)

**时间复杂度**: O(max(m,n))
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode ne = dummy;
        while(l1 != null || l2 != null){
            int l1val = l1==null ? 0 : l1.val;
            int l2val = l2==null ? 0 : l2.val;
            int sum = l1val + l2val + carry;

            ne.next = new ListNode(sum%10);
            ne=ne.next;
            carry = sum/10;

            if(l1 != null) l1=l1.next; 
            if(l2 != null) l2=l2.next; 
        }
        if(carry!=0) ne.next = new ListNode(carry);
        return dummy.next;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
