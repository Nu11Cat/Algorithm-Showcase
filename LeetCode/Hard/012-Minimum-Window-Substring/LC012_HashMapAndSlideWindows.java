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