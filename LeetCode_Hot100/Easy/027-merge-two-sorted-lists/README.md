# [21. 合并两个有序链表] 
## (https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 递归 | 链表


### 问题描述
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

### 解法分析（详细注释见Java文件）
### 方法1 迭代

创建一个哨兵节点，dummy.next是合并后的实际链表的头节点
tail用于跟踪新链表的末尾

**时间复杂度**: O(n+m)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode up = list1,down = list2;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while(up != null && down !=null){
            if(up.val>down.val){
                result.next=down;
                down=down.next;
            }
            else {
                result.next=up;
                up=up.next;
            }
            result=result.next;
        }
        if(down != null) result.next = down;
        if(up != null) result.next = up;
        return dummy.next;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
