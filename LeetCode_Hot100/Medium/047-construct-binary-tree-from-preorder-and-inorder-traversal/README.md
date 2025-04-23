# [105. 从前序与中序遍历序列构造二叉树] 
## (https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
树
数组
哈希表
分治
二叉树


### 问题描述
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

### 解法分析（详细注释见Java文件）

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
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<Integer,Integer>();
        int n = preorder.length;
        for(int i = 0; i < n; i++){
            map.put(inorder[i],i);
        }
        return mybuilderTree(preorder,inorder,0,n-1,0,n-1);
    }

    public TreeNode mybuilderTree(int[] preorder,int[] inorder,int preleft,int preright,int inleft,int inright){
        if(preleft>preright){return null;}
        int preroot = preleft;
        int inroot = map.get(preorder[preroot]);
        TreeNode root = new TreeNode(preorder[preroot]);
        int n = inroot - inleft;
        root.left = mybuilderTree(preorder,inorder,preleft+1,preroot+n,inleft,inleft+n-1);
        root.right = mybuilderTree(preorder,inorder,preleft+n+1,preright,inroot+1,inright);
        return root;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
