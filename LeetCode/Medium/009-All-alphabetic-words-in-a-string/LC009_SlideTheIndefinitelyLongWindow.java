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