# [46. 全排列] 
## (https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
数组
回溯


### 问题描述
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

### 解法分析（详细注释见Java文件）

**时间复杂度**: O(n×n!)
**空间复杂度**: O(n)
```java
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] used;
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        used = new int[len+1];
        if(len == 0) return result;
        back(nums);
        return result;
    }
    void back(int[] nums){
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(used[i]==1) continue;
            path.add(nums[i]);
            used[i]=1;
            back(nums);
            used[i]=0;
            path.remove(path.size()-1);
        }
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
