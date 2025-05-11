# [207. 课程表] 
## (https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 
深度优先搜索
广度优先搜索
图
拓扑排序



### 问题描述
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
### 解法分析（详细注释见Java文件）
### 方法1 BFS

扑排序 + 入度表 + 队列

**时间复杂度**: O(n+m)
**空间复杂度**: O(n+m)
```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ru = new int[numCourses];
        List<List<Integer>> yilai = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            yilai.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            int nru=i[0];
            ru[nru]++;
            yilai.get(i[1]).add(nru);
        }
        for(int i = 0;i<numCourses;i++){
            if(ru[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            numCourses--;
            for(int i: yilai.get(temp)){
                ru[i]--;
                if(ru[i]==0) queue.offer(i);
            }
        }
        return numCourses == 0;
    }
}
//【4，1】   【2  1】  【4， 2】  【3 ， 2】 【5  3】 【5   4】
//【n的入度，n的出度】
//表表示依赖我的”课程们“
```
### 方法2 DFS


**时间复杂度**: O(n+m)
**空间复杂度**: O(n+m)
```java
class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] status = new int[numCourses];
        List<List<Integer>> yilai = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            status[i]=0;
            yilai.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            int nru=i[0];
            yilai.get(i[1]).add(nru);
        }
        for(int i = 0;i<numCourses;i++){
            if(!dfs(yilai,status,i)) return false;
        }
        
        return true;
    }
    public boolean dfs(List<List<Integer>> yilai,int[] status,int i){
        if(status[i]==1) return false;
        if(status[i]==-1) return true;
        status[i]=1;
        for(int j : yilai.get(i)){
            if(!dfs(yilai,status,j)) return false;
        }
        status[i]=-1;
        return true;
    }
}
//【4，1】   【2  1】  【4， 2】  【3 ， 2】 【5  3】 【5   4】
//【n的入度，n的出度】
//表表示依赖我的”课程们“
//1表示正在递归
//-1表示递归完成

```
### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
