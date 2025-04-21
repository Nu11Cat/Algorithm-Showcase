# [102. 二叉树的层序遍历] 
## (https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 | 模拟 | 矩阵


### 问题描述
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list1 = new ArrayList<>();
        if(root == null) return list1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode temp = queue.poll();
                list2.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            list1.add(list2);
        }
        return list1;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
