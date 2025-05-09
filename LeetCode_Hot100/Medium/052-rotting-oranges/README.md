# [994. 腐烂的橘子] 
## (https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
广度优先搜索
数组
矩阵


### 问题描述
在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

### 解法分析（详细注释见Java文件）

**时间复杂度**: O(nm)
**空间复杂度**: O(nm)s
```java
class Solution {
    public int orangesRotting(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int fresh = 0;
        Queue<int[]>queue = new LinkedList<>();
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(grid[i][j]==2) {
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int ans = 0;
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] poll = queue.poll();
                for(int[] dir : dirs){
                    int xx = poll[0]+dir[0];
                    int yy = poll[1]+dir[1];
                    if(check(grid,xx,yy) && grid[xx][yy]==1){
                        grid[xx][yy] = 2;
                        fresh--;
                        queue.offer(new int[]{xx,yy});
                    }
                }
            }
            ans++;
        }
        return fresh == 0?ans-1:-1;
    }
    boolean check(int[][] grid,int a,int b){
        return a>=0 && a<grid.length && b>=0 && b<grid[0].length;
    }
}
```

### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
