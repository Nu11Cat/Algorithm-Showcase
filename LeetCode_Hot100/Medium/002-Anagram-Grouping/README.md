# [49. 字母异位词分组] 
## (https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 |  哈希表 | 字符串 | 排序


### 问题描述
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的所有字母得到的一个新单词。


### 解法分析（详细注释见Java文件）
*注意*字母异位词就是相同个数字母的不同组合
### 方法1 排序

对每个字符串sort排序，以此为键组件哈希表
哈希表一个键通常对应一个值，但可以通过将值设为列表等数据结构来间接实现一个键对应多个值
使用computeIfAbsent可以避免不必要的计算，提高性能(末尾会有介绍)
**时间复杂度**: O(nklogk) k为字符串最大长度
**空间复杂度**: O(nk)
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for( String i : strs ){
            char[] array = i.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(i);
        }
        Set<String> keys = map.keySet();
        return new ArrayList<List<String>>(map.values());
    }
}
```

### 方法2 计数

其实此方法和方法一基本逻辑相似，只是方法一使用sort排序结果作为键，而方法二采用“字母+次数”作为键
基本逻辑相似，只是少了避免了sort，提高效率

**时间复杂度**: O(n(k+∣Σ∣)) k为字符串最大长度  ∣Σ∣=26
**空间复杂度**: O(n(k+∣Σ∣)) 
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map =new HashMap<String,List<String>>();
        for(String str:strs){
            int[] counts=new int[26];
            for(int i = 0; i < str.length(); i++){
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < 26; i++){
                if(counts[i] != 0) {
                    sb.append((char)('a'+i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
```
### 比较与总结
#### 相似之处：
两种方法都依赖于将字母异位词映射到同一个键。
都使用了哈希表来存储和分组结果。
#### 不同之处：
键的生成方式：排序法通过排序后的字符串生成键，而计数法通过字母出现次数的编码生成键。
时间复杂度：排序法的时间复杂度为 O(K log K)，计数法为 O(K)。
#### 选择哪种方法？
如果字符串长度较短，排序法和计数法的性能差异不大，可以根据个人偏好选择。
如果字符串长度较长，计数法通常更高效，因为它避免了排序的开销。


### 特殊处理

**computeIfAbsent** 是 Java 8 引入的一个非常有用的方法，
主要用于在 Map 中根据指定的键（key）来计算并插入一个值（value）。
如果该键在 Map 中不存在或其对应的值为 null，则使用提供的函数计算一个新值，并将其与键关联起来。否则，返回现有的值。

#### computeIfAbsent 常用于以下场景：
**懒加载**：当需要根据键动态计算值时，可以避免不必要的计算。
**缓存**：在缓存实现中，可以用它来存储和检索计算结果。
**构建嵌套数据结构**：例如，构建多层 Map 或树形结构。