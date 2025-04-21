# [108. 将有序数组转换为二叉搜索树] 
## (convert-sorted-array-to-binary-search-tree)

#### **标签** 数组 | 模拟 | 矩阵


### 问题描述
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。

### 解法分析（详细注释见Java文件）


**时间复杂度**: O(n)
**空间复杂度**: O(logn)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toleft(nums,0,nums.length-1);
    }
    public TreeNode toleft(int[] nums, int left, int right){
        if(left>right) return null;

        int mid = (left + right) / 2;
        TreeNode tree = new TreeNode(nums[mid]);
        tree.left = toleft(nums,left,mid-1);
        tree.right = toleft(nums,mid+1,right);
        return tree;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
