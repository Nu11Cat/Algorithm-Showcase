# [226. 翻转二叉树] 
## (https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 树 | 深度优先搜索 | 广度优先搜索 | 二叉树


### 问题描述
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。


示例 1：



输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
示例 2：



输入：root = [2,1,3]
输出：[2,3,1]
示例 3：

输入：root = []
输出：[]
 

提示：

树中节点数目范围在 [0, 100] 内
-100 <= Node.val <= 100
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
