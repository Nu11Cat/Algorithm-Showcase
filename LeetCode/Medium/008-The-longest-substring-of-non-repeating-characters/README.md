# [3. 无重复字符的最长子串] 
## (https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 哈希表 |  字符串 | 滑动窗口


### 问题描述
给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度


### 解法分析（详细注释见Java文件）
### 方法1 滑动窗口（HashSet）

更常规好理解

**时间复杂度**: O(n)
**空间复杂度**: O(1)
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs=new HashSet<>();
        int n=s.length();
        int ans=0;
        for(int l=0,r=0;r<n;r++){
            while(l<r && hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}
```

### 方法2 滑动窗口（HashMap）（hard）

​**Math.max() 的作用**：防止窗口左边界 j 回退到更小的位置。
例如在 "abba" 中，当处理最后一个 a 时，map.get('a') = 1，但此时 j 已经是2，必须保持 j 的单调递增，否则窗口会包含重复字符 b。
​**存储 i + 1 的意义：**
确保下次遇到相同字符时，窗口左边界 j 直接跳到重复字符的下一个位置，避免窗口包含该重复字符。

**时间复杂度**: O(n)
**空间复杂度**: O(1)
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int ans = 1, max = 1;
        for(int i = 0,j = 0; i < s.length(); i++){
            char index=s.charAt(i);
            if(map.containsKey(index)){
                j=Math.max(map.get(index),j);
            }
            max=Math.max(max,i-j+1);
            map.put(s.charAt(i),i+1);
        }
        return max;
    }
}
```


### 比较与总结
#### 不同之处：

#### 选择哪种方法？


### 特殊处理
此题目无特殊处理
