# [239. 滑动窗口最大值] 
## (https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 队列 | 数组 | 滑动窗口 | 单调队列 | 堆 


### 问题描述
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。


### 解法分析（详细注释见Java文件）

### 方法1 按照行求（超时）

我们需要高效地找到每个窗口的最大值。为了做到这一点，我们使用一个 ​双端队列（Deque）​​ 来维护当前窗口中的 ​可能成为最大值的元素**索引**。
**对于每个元素 nums[i]：**
    1 ​移除队列中所有小于当前元素的索引：因为如果 nums[j] < nums[i]，那么 nums[j] 不可能是当前窗口的最大值。
    2 ​将当前元素索引加入队列尾部：因为 nums[i] 可能是未来窗口的最大值。
    3 ​移除窗口外的索引：如果队头索引已经不在当前窗口范围内（即 deque.peekFirst() == i - k），移除它。
    4 ​记录当前窗口的最大值：如果当前窗口已经形成（即 i >= k - 1），将队头元素（当前窗口的最大值）加入 result。
**时间复杂度**: O(n) 
**空间复杂度**: O(k) 队列中最多存储 k 个元素。
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[n+1-k];
        for(int i = 0; i < n;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            deque.offerLast(i);
            if(deque.peekFirst()<=i-k) deque.removeFirst();
            if(i>=k-1) arr[i-k+1] = nums[deque.peekFirst()];
        }
        return arr;
    }
}
```


### 比较与总结
**双端队列的常见用法包括：**

实现栈和队列。
滑动窗口最大值。
回文检查。
BFS。
单调队列


### 特殊处理
此题目无特殊处理
