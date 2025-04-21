# [543. 二叉树的直径] 
## (https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 树 | 深度优先搜索 | 二叉树


### 问题描述
给你一棵二叉树的根节点，返回该树的 直径 。

二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

两节点之间路径的 长度 由它们之间边数表示。

### 解法分析（详细注释见Java文件）

![alt text](image-1.png)

**时间复杂度**: O(n)
**空间复杂度**: O(Height)
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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 1;
        depth(root);
        return max - 1;
    }

    public int depth(TreeNode root){
        if(root == null ) return 1;
        int le = depth(root.left);
        int ri = depth(root.right);
        max = Math.max(max,le+ri-1);
        return Math.max(ri,le)+1;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
