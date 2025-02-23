# [128. 最长连续序列] 
## (https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 |  哈希表 | 并查集


### 问题描述
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。


### 解法分析（详细注释见Java文件）
*注意*排序的时间复杂度是O(nlogn)，不符合题目O(n)的要求。
### 方法1 排序(不符合题意)

sort排序再循环遍历
**时间复杂度**: O(nlogn)
**空间复杂度**: O(log n)
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int sum = 1, max = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == 0) continue;
            if(nums[i] - nums[i-1] == 1 ) sum++;
            else sum = 1;
            max=Math.max(sum,max);
        }
        return max;
    }
}
```

### 方法2 哈希表

对于每个x，查找x+1，x+2...是否在nums中，并统计序列的长度。
**时间复杂度**: O(N)
**空间复杂度**: O(N)
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int max=0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        for(int i : set){
            if( set.contains(i-1) ) continue;
            int sum = 1, y = i + 1;
            while(set.contains(y)){
                y++;
                sum++;
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}
```


### 比较与总结
#### 选择哪种方法？
方法一适用场景：适用于数据规模较小的情况，或者在时间和空间复杂度要求不高的场景。
方法二适用于数据规模较大，对时间效率要求较高的场景。

### 特殊处理
此题目无特殊处理



## sort介绍
Arrays.sort 方法不是线程安全的
**对于基本数据类型数组**
```java
public static void sort(int[] a)
public static void sort(int[] a, int fromIndex, int toIndex)
// 其他基本类型如 double[], char[], etc.
```
使用双轴快速排序,这是对传统快速排序的优化，平均时间复杂度为 O(n log n)，在大多数情况下表现优异。

**对于对象类型数组**
```java
public static <T> void sort(T[] a)
public static <T> void sort(T[] a, Comparator<? super T> c)
// 其他对象类型如 String[], Integer[], etc.
```
使用归并排序,这是一种稳定的排序算法,时间复杂度为 O(n log n)
