# [15. 三数之和] 
## (https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 |  双指针 | 排序


### 问题描述
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。


### 解法分析（详细注释见Java文件）
*注意*答案中不可以包含重复的三元组
### 方法1 双指针

难点在于如何去除重复解
第一种情况是 //-4 -1 -1 0 1 2 for循环到第二个-1的时候应该跳过，因为第一个-1已经完成所有组合，去的是索引的重复
第二种是//-2 0 0 2 2，索引到-2 和 0 2的时候应该取里面的0和2：-2 0 *0 2* 2，去的是指针的重复

**时间复杂度**: O(N^2)
**空间复杂度**: O(1)
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null && nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> list1=new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            if( (i != 0  && nums[i - 1] == nums[i] ) || nums[i]>0) continue;
            int left = i + 1,rigth = nums.length-1;
            while(left < rigth){
                int sum = nums[i] + nums[left] + nums[rigth];
                if(sum == 0){
                    list1.add(Arrays.asList(nums[i] , nums[left] , nums[rigth]));
                    while(left < rigth && nums[left + 1] == nums[left]) left++;
                    while(left < rigth && nums[rigth - 1] == nums[rigth]) rigth--;
                    left++;
                    rigth--;
                }
                else if(sum > 0){
                    rigth--;
                }
                else {
                    left++;
                }
            }
        }
        return list1;
    }
}
```



### 特殊处理
两次去重
