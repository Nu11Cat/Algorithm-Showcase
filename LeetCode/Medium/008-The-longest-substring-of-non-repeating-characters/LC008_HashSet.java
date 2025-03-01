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