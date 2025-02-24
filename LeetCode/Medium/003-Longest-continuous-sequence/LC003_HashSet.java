import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int max=0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        for(int i : set){
            if( set.contains(i-1) ) continue;
            int sum = 1, y = i + 1;
            while(set.contains(y)){
                y++;
                sum++;
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}