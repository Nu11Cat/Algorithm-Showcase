# [30. 二叉搜索树中第 K 小的元素] 
## (https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
树
深度优先搜索
二叉搜索树
二叉树


### 问题描述
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。

### 解法分析（详细注释见Java文件）
### 方法1 栈遍历


**时间复杂度**: O(H+k)
**空间复杂度**: O(H)
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
    public int kthSmallest(TreeNode root, int k) {
        int kk = k;
        Deque<TreeNode> stack = new LinkedList<>();
        while(kk!=0){
            while(root!=null){
                stack.push(root);
                root = root.left; 
            }
            root = stack.pop();
            --kk;
            if(kk==0) break;
            root = root.right;
        }
        return root.val;
    }
}
```
### 方法2 递归遍历


**时间复杂度**: O(H)
**空间复杂度**: O(H)
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
    List<Integer> st = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
        traverse(root);
        int res = st.get(k-1);
        return res;
    }
    //二叉搜索树的中序遍历就是升序排列
    void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        st.add(root.val);
        traverse(root.right);
    }
}
```
### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
