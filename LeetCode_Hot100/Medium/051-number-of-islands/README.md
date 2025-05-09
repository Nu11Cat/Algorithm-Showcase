# [200. 岛屿数量] 
## (https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
深度优先搜索
广度优先搜索
并查集
数组
矩阵


### 问题描述
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

### 解法分析（详细注释见Java文件）

**时间复杂度**: O(nm)
**空间复杂度**: O(nm)
```java
class Solution {
    public int ans = 0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans ;
    }
    void dfs(char[][] grid,int a,int b){
        if(!check(grid,a,b)) return;
        if(grid[a][b]!='1') return;
        grid[a][b]='2';
        dfs(grid,a-1,b);
        dfs(grid,a+1,b);
        dfs(grid,a,b+1);
        dfs(grid,a,b-1);
    }
    boolean check(char[][] grid,int a,int b){
        return a>=0 && a<grid.length && b>=0 && b<grid[0].length;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
