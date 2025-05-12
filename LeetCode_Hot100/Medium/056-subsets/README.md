# [78. 子集] 
## (https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
位运算
数组
回溯


### 问题描述
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。


示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
### 解法分析（详细注释见Java文件）

```java
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        back(nums,0);
        return result;
    }
    void back(int[] nums,int idx){
        result.add(new ArrayList<>(path));
        if(idx >= nums.length){
            return;
        }
        for(int i=idx;i<nums.length;i++){
            path.add(nums[i]);
            back(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}//2 ^n
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
