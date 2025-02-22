class Solution {
    public int[] twoSum(int[] nums, int target) {
        //使用的是 length 属性，而不是方法。因此，语法是 nums.length，而不是nums.length()
        //动态大小的数据结构，如ArrayList、LinkedList，才使用size() 方法
        int n=nums.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                //使用临时变量存储结果
                //相当于int[] result = {i, j}; return result;
                if(nums[i] + nums[j] == target) return new int[]{i, j};

            }
        }
        //方法的返回类型是 int[]，最终必须返回一个整数数组。
        //比返回 null 更安全（不需要额外检查返回值是否为 null）
        return new int[0];

    }
}