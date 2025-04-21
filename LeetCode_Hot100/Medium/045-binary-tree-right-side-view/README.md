# [199. 二叉树的右视图] 
## (https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
树
深度优先搜索
广度优先搜索
二叉树


### 问题描述
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

### 解法分析（详细注释见Java文件）
### 方法1 分层模拟


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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list1 = new ArrayList<>();
        if(root == null) return list1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                if(i==n-1) list1.add(queue.peek().val);
                TreeNode tree = queue.poll();
                if(tree.left != null){
                    queue.add(tree.left);
                }
                if(tree.right != null){
                    queue.add(tree.right);
                }
            }
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
