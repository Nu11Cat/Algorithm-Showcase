# [101. 对称二叉树] 
## (https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 树 | 深度优先搜索 | 广度优先搜索 | 二叉树


### 问题描述
给你一个二叉树的根节点 root ， 检查它是否轴对称。

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
    public boolean isSymmetric(TreeNode root) {
        return equals(root.left,root.right); 
    }

    public boolean equals(TreeNode le , TreeNode ri){
        if(le == null && ri == null){
            return true;
        }
        if(le == null || ri == null){
            return false;
        }
        return le.val == ri.val && equals(le.left,ri.right) && equals(le.right,ri.left);
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
