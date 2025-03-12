# [148. 排序链表] 
## (https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 链表 | 双指针 | 分治 | 排序 | 归并排序


### 问题描述
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

### 解法分析（详细注释见Java文件）
### 方法1 归并排序


**时间复杂度**: O(nlogn)
**空间复杂度**: O(logn)
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
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }
    private ListNode sortList(ListNode tou,ListNode wei){
        if(tou == null) return tou;
        if(tou.next == wei){
            tou.next = null;
            return tou;
        }
        ListNode slow = tou ,fast = tou;
        while(fast!=wei){
            slow = slow.next;
            fast = fast.next;
            if(fast != wei) fast = fast.next;
        }
        ListNode qian = sortList(tou,slow);
        ListNode hou = sortList(slow,wei);
        ListNode ed = pinjie(qian,hou);
        return ed;
    }
    private ListNode pinjie(ListNode head1,ListNode head2){
        ListNode prummy = new ListNode(0);
        ListNode temp = prummy,temp1=head1,temp2=head2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next = temp1;
                temp1=temp1.next;
                temp=temp.next;
            }else {
                temp.next = temp2;
                temp2=temp2.next;
                temp=temp.next;
            }
        }
        if(temp1!=null) temp.next = temp1;
        if(temp2!=null) temp.next = temp2;
        return prummy.next;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
