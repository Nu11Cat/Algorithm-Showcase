# [1. 两数之和] 
## (https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 |  哈希表


### 问题描述
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
你可以按任意顺序返回答案。


### 解法分析（详细注释见Java文件）
*注意*返回数组下标，不是数组对应的值
### 方法1 暴力枚举

两层 for 循环嵌套，枚举数组中的每一个数
**时间复杂度**: O(N^2)
**空间复杂度**: O(1)
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[0];
    }
}
```

### 方法2 哈希表

暴力嵌套的时间复杂度过高
考虑到我们需要“ *快速寻找数组中是否存在目标元素* ”，我们可以使用哈希表来寻找 target-x
**时间复杂度**: O(N)
**空间复杂度**: O(N)
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(table.containsKey(target - nums[i])){
                return new int[]{table.get(target - nums[i]),i};
            }
            table.put(nums[i], i);
        }
        return new int[0];
    }
}
```


### 比较与总结
#### 不同之处：
方法1的时间复杂度为O(N^2)，因为它需要遍历整个数组的所有可能组合。方法2的时间复杂度为O(N)，因为它只需要遍历一次数组，并通过哈希表进行快速查找。
方法1的空间复杂度为O(1)，因为它不需要额外的存储空间。而方法2的空间复杂度为O(N)，因为它需要使用哈希表来存储数组中的元素及其索引。
#### 选择哪种方法？
如果对时间复杂度要求不高，或者数组的长度较短，可以选择方法1，因为它实现简单，不需要额外的存储空间。
如果需要在较短的时间内找到结果，尤其是在数组长度较大的情况下，应选择方法2。虽然它需要额外的存储空间，但时间复杂度更低，能更快地找到符合条件的两个数。


### 特殊处理
此题目无特殊处理
