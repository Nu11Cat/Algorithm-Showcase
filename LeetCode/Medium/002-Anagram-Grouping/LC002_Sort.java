class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for( String i : strs ){
            //字符串排序后作为键
            char[] array = i.toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);

            //如果键不存在，创建新的列表；否则，添加到现有列表
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(i);

        }

        // 返回所有分组后的列表
        return new ArrayList<List<String>>(map.values());
    }
}