# [240. 搜索二维矩阵 II] 
## (https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 | 二分查找 | 矩阵 |  分治


### 问题描述
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

### 解法分析（详细注释见Java文件）
### 方法1 二分遍历

**时间复杂度**: O(mlogn)
**空间复杂度**: O(1)
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] arr : matrix){
            int l=0,r=arr.length-1;

            while(l<=r){
                int mid = l + (r-l)/2;
                if(arr[mid]==target) return true;
                else if(arr[mid]>target) r=mid-1;
                else l=mid+1;
            }
        }
        return false;
        
    }
}
```
### 方法2 Z字形查找

**时间复杂度**: O(m+n)
**空间复杂度**: O(1)
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while(matrix[x][y] != target){
            if(matrix[x][y] > target) y--;
            else x++;
            if(x >= m || y < 0) return false;
        }
        return true;
    }
}
```
### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
