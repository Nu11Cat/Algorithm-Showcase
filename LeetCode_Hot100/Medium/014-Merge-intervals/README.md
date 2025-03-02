# [56. 合并区间] 
## (以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。)

#### **标签** 数组 | 排序


### 问题描述
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，并使用所有原字母一次
### 解法分析（详细注释见Java文件）
### 方法1 排序合并

按照区间的左端点排序，可以合并的区间一定是连续的
**时间复杂度**: O(nlogn)
**空间复杂度**: O(logn)
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->Integer.compare(a[0],b[0]));
        int index = 0;
        int start = intervals[0][0] ,end = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for(int[] arr : intervals){
            int x = arr[0],y=arr[1];
            if(x>start && x<=end && y>end) end=y;
            else if(x>end) {
                result.add(new int[]{start,end});
                start=x;
                end=y;
            }
            else if(y>end) end=y;
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);
    }
}
```


### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
