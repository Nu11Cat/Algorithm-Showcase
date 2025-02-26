class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(nums.length+1);
        int[] arr = new int[nums.length + 1];
        int ans=0;
        for(int i = 0;i < nums.length;i++){
            arr[i + 1] = arr[i] + nums[i];
            
            
        }
        for(int i : arr){
            if(map.containsKey(i-k)) ans += map.get(i-k);
             map.merge(i,1,Integer::sum);
        }
        return ans;
    }
}