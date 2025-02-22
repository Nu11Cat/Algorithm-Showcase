import java.util.Map;
import java.util.HashMap;
//哈希表（Hash Table）是一种通过哈希函数将键（key）映射到特定位置来实现快速数据存取的数据结构。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Map 是 Java 集合框架中的一个接口，用于存储键值对
        //HashMap 是 Map 接口的一个具体实现类，基于哈希表的数据结构。
        Map<Integer, Integer> table = new HashMap<Integer,Integer>();

        //挨个遍历x---能在哈希表找到target-x---return
        //        ---不能在哈希表找到target-x---把x存进哈希表后续循环作为查找的储备
        for(int i = 0; i < nums.length; i++){
            if(table.containsKey(target - nums[i])){
                return new int[]{table.get(target - nums[i]),i};
            }
            table.put(nums[i], i);
        }
        
        return new int[0];
    }
}