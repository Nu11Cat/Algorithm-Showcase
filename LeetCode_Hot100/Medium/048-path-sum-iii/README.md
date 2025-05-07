# [437. 路径总和 III] 
## (https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
树
深度优先搜索
二叉树


### 问题描述
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

### 解法分析（详细注释见Java文件）
### 方法1 分层模拟

![alt text](image-1.png)

**时间复杂度**: O(n*2)
**空间复杂度**: O(n)
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
    public int pathSum(TreeNode root, long targetSum) {
        if(root == null) return 0;
        int sum = 0;
        sum = path(root,targetSum);
        sum += pathSum(root.left,targetSum);
        sum += pathSum(root.right,targetSum);
        return sum;
    }
    public int path(TreeNode root ,long targetSum){
        if(root == null) return 0;
        int sum = 0;
        if(root.val == targetSum) sum++;
        sum+=path(root.left,targetSum-root.val);
        sum+=path(root.right,targetSum-root.val);
        return sum;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
