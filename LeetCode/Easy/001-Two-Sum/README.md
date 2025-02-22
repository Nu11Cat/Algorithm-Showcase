## [1. 两数之和] (https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked)

**标签** 数组 |  哈希表


### 问题描述
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
你可以按任意顺序返回答案。


#### 解法分析（详细注释见java文件）
*注意*返回数组下标，不是数组对应的值
##### 方法1 暴力枚举

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

##### 方法2 哈希表

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


### 测试示例
**输入**: nums = [3,3], target = 6  
**输出**: [0,1]