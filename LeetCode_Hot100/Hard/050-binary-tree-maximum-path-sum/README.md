# [124. 二叉树中的最大路径和] 
## (https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
树
深度优先搜索
动态规划
二叉树


### 问题描述
二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。

### 解法分析（详细注释见Java文件）


**时间复杂度**: O(n)
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
    public int maxx = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return maxx;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        maxx = Math.max(maxx,root.val+left+right);
        return root.val+Math.max(left,right);
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
