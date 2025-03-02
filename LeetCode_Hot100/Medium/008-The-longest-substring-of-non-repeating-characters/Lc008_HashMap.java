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