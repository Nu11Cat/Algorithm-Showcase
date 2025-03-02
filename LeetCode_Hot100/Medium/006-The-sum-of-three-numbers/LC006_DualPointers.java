import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null && nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> list1=new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            if( (i != 0  && nums[i - 1] == nums[i] ) || nums[i]>0) continue;
            int left = i + 1,rigth = nums.length-1;
            while(left < rigth){
                int sum = nums[i] + nums[left] + nums[rigth];
                if(sum == 0){
                    list1.add(Arrays.asList(nums[i] , nums[left] , nums[rigth]));
                    while(left < rigth && nums[left + 1] == nums[left]) left++;
                    while(left < rigth && nums[rigth - 1] == nums[rigth]) rigth--;
                    left++;
                    rigth--;
                }
                else if(sum > 0){
                    rigth--;
                }
                else {
                    left++;
                }
            }
        }
        return list1;
    }
}