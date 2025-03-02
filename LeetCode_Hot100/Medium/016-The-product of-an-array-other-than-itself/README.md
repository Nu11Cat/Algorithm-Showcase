# [238. 除自身以外数组的乘积] 
## (https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 | 前缀和


### 问题描述
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
**进阶：**你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
### 解法分析（详细注释见Java文件）
### 方法1 前缀和（空间复杂度优化ed）
常规思路就是三次for，分别用两次遍历来获取i前的数的乘积和后的成绩，类似前缀和
                    第三次遍历赋值
但是这种方法的复杂度是O（n）
实际上可以把后面两次的for合并，因为*出数组 不被视为 额外空间*，那么空间复杂度就是O（1）
**时间复杂度**: O(n)
**空间复杂度**: O(1)
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0]=1;
        for(int i=1;i<n;i++){
            result[i]=result[i-1]*nums[i-1];
        }
        int rr=1;
        for(int i=n-1;i>=0;i--){
            result[i]*=rr;
            rr*=nums[i];
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
