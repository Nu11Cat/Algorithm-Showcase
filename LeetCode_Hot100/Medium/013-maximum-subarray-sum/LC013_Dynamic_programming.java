class Solution {
    public int maxSubArray(int[] nums) {
        int a1=nums[0];
        int a2=nums[0];
        for(int i = 1 ; i < nums.length ;i++){
            a1=Math.max(nums[i],nums[i]+a1);
            a2=Math.max(a2,a1);
        }
        return a2;
    }
}