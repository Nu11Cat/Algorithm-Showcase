# [54. 螺旋矩阵] 
## (https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 | 模拟 | 矩阵


### 问题描述
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

### 解法分析（详细注释见Java文件）
### 方法1 分层模拟

![alt text](image-1.png)

**时间复杂度**: O(nm)
**空间复杂度**: O(1)
```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length,n=matrix[0].length;
        if(matrix==null || m ==0 || n==0) return list;
        int l=0,r=n-1;
        int t=0,b=m-1;
        while(list.size()<m*n){
            for(int y = l;y <= r;y++){ list.add(matrix[t][y]); }
            for(int x = t+1;x <= b;x++){ list.add(matrix[x][r]); }
            if(l < r && t < b){
                for(int y = r-1;y >= l+1;y--){ list.add(matrix[b][y]); }
            for(int x = b;x> t;x--){ list.add(matrix[x][l]); }
            }
            l++;r--;t++;b--;
        }
        return list;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
