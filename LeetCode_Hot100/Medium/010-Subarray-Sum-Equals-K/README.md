# [560. 和为 K 的子数组] 
## (https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 哈希表 |  字符串 | 滑动窗口


### 问题描述
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。
### 解法分析（详细注释见Java文件）
### 方法1 前缀和+暴力


**时间复杂度**: O(n²)
**空间复杂度**: O(n)
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] arr = new int[nums.length + 1];
        int ans=0;
        for(int i = 0;i < nums.length;i++){
            arr[i + 1] = arr[i] + nums[i]; 
        }
        arr[0]=0;
        for(int i=0;i<nums.length+1;i++){
            for(int j=i+1;j<nums.length+1;j++){
                if(arr[j]-arr[i]==k && i!=j) ans++;
            }
        }
        return ans;
    }
}
```

### 方法2 前缀和+哈希表优化

**时间复杂度**: O(n)
**空间复杂度**: O(n)
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(nums.length+1);
        int[] arr = new int[nums.length + 1];
        int ans=0;
        for(int i = 0;i < nums.length;i++){
            arr[i + 1] = arr[i] + nums[i];
            
            
        }
        for(int i : arr){
            if(map.containsKey(i-k)) ans += map.get(i-k);
             map.merge(i,1,Integer::sum);
        }
        return ans;
    }
}
```


### 比较与总结

### 特殊处理
**map.merge(i,1,Integer::sum);**
1. `map.merge(i, 1, Integer::sum)` 是 Java 8 引入的 `Map` 接口方法，用于更新哈希表中的键值对。  
2. 如果键 `i` 不存在，则插入 `(i, 1)`。  
3. 如果键 `i` 已存在，则使用 `Integer::sum` 函数将旧值和新值相加。  
4. `Integer::sum` 是方法引用，等价于 `(oldValue, newValue) -> oldValue + newValue`。  
5. 该方法可以避免手动检查键是否存在，简化代码逻辑。  
6. 它常用于统计频率或累加值。  
7. 在这里，`map.merge(i, 1, Integer::sum)` 用于记录前缀和 `i` 的出现次数。  
8. 如果 `i` 已存在，则将其值加 1；如果不存在，则初始化为 1。  
9. 这种方法高效且简洁，避免了冗余的 `if-else` 逻辑。  
10. 它是处理哈希表更新的一种推荐方式，特别适合统计类问题。