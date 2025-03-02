# [283. 移动零] 
## (https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 |  双指针


### 问题描述
定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。


### 解法分析（详细注释见Java文件）
*注意*void型，无返回值
### 方法1 双指针1

最简单直接的方法，非零前移，剩下的用0补齐
**时间复杂度**: O(n)
**空间复杂度**: O(1)
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] != 0) nums[j++]=nums[i];
        }
        for(int i = j;i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
```

### 方法2 双指针2

使用i和j双指针指向0和非0的位置，通过互换把非0数字前移把0后移动
**时间复杂度**: O(n)
**空间复杂度**: O(1)
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] != 0){
                int tmp = nums[i];
				nums[i] = nums[j];
				nums[j++] = tmp;
            }
        }
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
