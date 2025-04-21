# [94. 二叉树的中序遍历] 
## (https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 栈 | 树 | 深度优先搜索 | 二叉树


### 问题描述
给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(list,root);
        return list;
    }


    public void inorder(List<Integer> list,TreeNode root){
        if(root == null) return;
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
