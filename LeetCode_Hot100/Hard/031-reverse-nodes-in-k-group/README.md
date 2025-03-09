# [25. K 个一组翻转链表] 
## (https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 递归 | 链表


### 问题描述
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

### 解法分析（详细注释见Java文件）
### 方法1 模拟

![alt text](image-1.png)

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prummy = new ListNode(0);
        prummy.next = head;

        ListNode tou = head;
        ListNode touqian = prummy;
        while(tou!=null){
            ListNode n=touqian;
            for(int i=0;i<k;i++){
                n=n.next;
                if(n==null) return prummy.next;
            }
                ListNode nnext=n.next;
                ListNode[] zhong = swqp(tou,n);
                tou = zhong[0];
                n = zhong[1];
                touqian.next=tou;
                n.next=nnext;
                touqian=n;
                tou=n.next;
        }
        return prummy.next;
    }
    private ListNode[] swqp(ListNode tou,ListNode wei){
        ListNode next = tou;
        ListNode result = wei.next;
        while(result != wei){
            ListNode temp = next.next;
            next.next = result;
            result = next;
            next = temp;
        }
        return new ListNode[]{wei,tou};
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
