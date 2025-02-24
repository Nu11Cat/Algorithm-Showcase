import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int sum = 1, max = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == 0) continue;
            if(nums[i] - nums[i-1] == 1 ) sum++;
            else sum = 1;
            max=Math.max(sum,max);
        }
        return max;
    }
}
