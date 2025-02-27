# [76. 最小覆盖子串] 
## (https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 字符串 | 哈希表 | 滑动窗口


### 问题描述
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

### 解法分析（详细注释见Java文件）

### 方法1 滑动窗口+哈希表

map1用来记录t的每个字符和出现的次数，是不变的
map2用来记录t的每个字符和出现的次数
win表示{窗口长度，窗口起始位置，窗口结束位置}
count表示map1 2满足出现次数相同的种类个数 当count == map1.size()意味着已经实现“覆盖”

**时间复杂度**: O(n) 
**空间复杂度**: O(1)
```java
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        int[] win = {-1,0,0};
        for(int i = 0 ; i < t.length() ;i++){
            map1.merge(t.charAt(i),1,Integer::sum);
            //map1.put(t.charAt(i),map1.geyOrDefult(t.charAt(i),0)+1);
        }
        int count=0;
        for(int l = 0, r = 0; r < s.length(); r++){
            map2.merge(s.charAt(r),1,Integer::sum);
            char c=s.charAt(r);
            if(map1.containsKey(c) && map1.get(c).intValue()==map2.get(c).intValue()) count++;
            while(l<=r && count == map1.size()){
                char d=s.charAt(l);
                if(win[0]==-1 || r-l+1<win[0]) {
                    win[0]=r-l+1;
                    win[1]=l;
                    win[2]=r;
                }
                map2.put(d,map2.get(d)-1);
                if(map1.containsKey(d) && map1.get(d).intValue()>map2.get(d).intValue()) count--;
                l++;
            }
        }
        return win[0]==-1 ? "" : s.substring(win[1],win[2]+1);
    }
}
```


### 比较与总结


### 特殊处理
此题目无特殊处理
