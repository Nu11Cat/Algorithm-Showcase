# [234. 回文链表] 
## (https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 栈 | 递归 | 链表 | 双指针


### 问题描述
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

### 解法分析（详细注释见Java文件）
### 方法1 双指针

将值复制到list中后用双指针法

**时间复杂度**: O(n)
**空间复杂度**: O(n)
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
```
### 方法2 反转链表

**使用快慢指针找到链表的中点**：定义两个指针，slow 和 fast，初始时都指向链表头部。fast 每次移动两步，slow 每次移动一步。当 fast 到达链表末尾时，slow 正好位于链表的中间位置。


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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head,slow = head;
        ListNode pre = null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            ListNode temp = slow.next;
            slow.next=pre;
            pre=slow;
            slow=temp;
        }
        if(fast != null) slow=slow.next;
        while(slow !=null && pre != null){
            if(slow.val != pre.val) return false;
            slow=slow.next;
            pre=pre.next;
        }
        return true;
    }
}
```
### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
