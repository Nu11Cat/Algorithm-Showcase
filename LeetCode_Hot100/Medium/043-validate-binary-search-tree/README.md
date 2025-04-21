# [98. 验证二叉搜索树] 
## (https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
树
深度优先搜索
二叉搜索树
二叉树


### 问题描述
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 

### 解法分析（详细注释见Java文件）
### 方法1 分层模拟


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
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean check(TreeNode root,long minvalue,long maxvalue){
        if(root == null) return true;
        if(root.val<= minvalue || root.val>=maxvalue){
            return false;
        }
        return check(root.left,minvalue,root.val) && check(root.right,root.val,maxvalue);
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
