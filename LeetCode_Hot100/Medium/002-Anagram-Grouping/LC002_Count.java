import java.util.*;

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