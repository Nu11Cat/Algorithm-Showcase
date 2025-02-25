# [438. 找到字符串中所有字母异位词] 
## (https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 哈希表 |  字符串 | 滑动窗口


### 问题描述
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，并使用所有原字母一次
### 解法分析（详细注释见Java文件）
### 方法1 滑动定长窗口

常规定长窗口：
for(int right = 0; right < s.length(); right++){
    ...
    int left = right + 1 - k;
    if(left < 0) continue;
    ...
}

**时间复杂度**: O(∣Σ∣m+n)，其中 m 是 s 的长度，n 是 p 的长度，∣Σ∣=26 是字符集合的大小。
**空间复杂度**: O(∣Σ∣)
```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arrs=new int[26];
        int[] arrp=new int[26];
        List<Integer> list=new ArrayList<>();
        for(int i = 0 ;i < p.length(); i++){
            arrp[p.charAt(i)-'a']++;
        }
        for(int right = 0; right < s.length(); right++){
            arrs[s.charAt(right)-'a']++;
            int left = right + 1 - p.length();
            if(left < 0) continue;
            if(Arrays.equals(arrs,arrp)) list.add(left);
            arrs[s.charAt(left)-'a']--;
        }
        return list;
    }
}
```

### 方法2 滑动不定长窗口

常规不定长窗口：
for(int right = 0; right < s.length(); right++){
    ...
    while( l < r && check()){
        ...
    }
    ...
}

**时间复杂度**: O(n)
**空间复杂度**: O(1)
```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr = new int[26];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < p.length(); i++){
            arr[p.charAt(i)-'a']++;
        }
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char cc = s.charAt(right);
            arr[cc-'a']--;
            while(arr[cc-'a'] < 0){
                arr[s.charAt(left)-'a']++;
                left++;
            }
            if(right - left + 1 == p.length()) list.add(left);
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
