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