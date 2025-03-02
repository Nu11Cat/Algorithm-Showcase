# [73. 矩阵置零] 
## (https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 | 哈希 | 矩阵


### 问题描述
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

### 解法分析（详细注释见Java文件）
### 方法1 使用标记数组

使用        boolean[] h = new boolean[matrix.length]; 
            boolean[] l = new boolean[matrix[0].length];
表示行和列是不是0

**时间复杂度**: O(nm)
**空间复杂度**: O(m+n)
```java
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] h = new boolean[matrix.length];
        boolean[] l = new boolean[matrix[0].length];
        for(int i = 0 ; i < matrix.length;i++){
            for(int j = 0 ; j < matrix[0].length;j++){
                if(matrix[i][j]==0) h[i]=l[j]=true;

            }
        }
        for(int i = 0 ; i < matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(h[i]==true || l[j]==true) matrix[i][j]=0;
            }
        }
    }
}
```
### 方法2 使用标记变量

思路与1相同，但是使用第0行和第0列代替boolean[] h和boolean[] l，所以需要两个变量来表示第0行和第0列是不是0
不过感觉没必要，屎山换空间

**时间复杂度**: O(nm)
**空间复杂度**: O(1)
```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}

```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
