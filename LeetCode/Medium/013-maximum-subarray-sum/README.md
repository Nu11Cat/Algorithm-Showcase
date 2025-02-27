# [53. 最大子数组和] 
## (https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 | 分治 | 动态规划


### 问题描述
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组是数组中的一个连续部分。

### 解法分析（详细注释见Java文件）

### 方法1 暴力+前缀和(超时)


**时间复杂度**: O(n^2) 
**空间复杂度**: O(n)
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int[] arr=new int[nums.length+1];
        arr[0]=0;
        for(int i = 0; i < nums.length ;i++){
            arr[i+1]=arr[i]+nums[i];
        }
        int n=nums.length,max=Integer.MIN_VALUE;
        for(int i = 0; i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(arr[j]-arr[i]>max && i!=j) max=arr[j]-arr[i];
            }
        }
        return max==Integer.MIN_VALUE ? arr[1] : max;
    }
}
```

### 方法2 动态规划（Kadane算法）

遍历数组时，维护两个变量：
    a1：以当前元素结尾的子数组的最大和。
    a2：全局最大子数组和。
每一步选择是否扩展当前子数组或重新开始：

**时间复杂度**: O(n) 
**空间复杂度**: O(1)
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int a1=nums[0];
        int a2=nums[0];
        for(int i = 1 ; i < nums.length ;i++){
            a1=Math.max(nums[i],nums[i]+a1);
            a2=Math.max(a2,a1);
        }
        return a2;
    }
}
```

### 比较与总结


### 特殊处理
此题目无特殊处理
