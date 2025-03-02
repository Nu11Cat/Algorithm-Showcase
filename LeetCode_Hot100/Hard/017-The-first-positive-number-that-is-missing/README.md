# [41. 缺失的第一个正数] 
## (https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 | 哈希表


### 问题描述
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。

### 解法分析（详细注释见Java文件）
### 方法1 暴力


**时间复杂度**: O(n) 
**空间复杂度**: O(n)
```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 将所有正数存入集合
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        // 从1开始逐个检查最小缺失值
        int min = 1;
        while (set.contains(min)) {
            min++;
        }
        return min;
    }
}
```

### 方法2 置换

通过把nums[i]-1放到i的位置，比如，[3,4,-1,1]置换后是[1,-1,3,4]就能得到缺失的最小正整数是2

**时间复杂度**: O(n) 
**空间复杂度**: O(1)
```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>=1 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){ swap(nums,nums[i]-1,i); }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return n+1;
    }
    private void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}
```


### 比较与总结


### 特殊处理
此题目无特殊处理
