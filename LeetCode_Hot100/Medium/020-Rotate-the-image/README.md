# [48. 旋转图像] 
## (https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 | 数学 | 矩阵


### 问题描述
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

### 解法分析（详细注释见Java文件）
### 方法1 分层模拟

**时间复杂度**: O(nm)
**空间复杂度**: O(1)
```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l=0,r=n-1,t=0,b=n-1;
        while(l<r && t<b){
            for(int i= 0 ;i<r-l ; i++){
                int temp = matrix[t][l+i];
                matrix[t][l+i]=matrix[b-i][l];
                matrix[b-i][l]=matrix[b][r-i];
                matrix[b][r-i]=matrix[t+i][r];
                matrix[t+i][r]=temp;
            }
            l++;r--;t++;b--;
        }
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
