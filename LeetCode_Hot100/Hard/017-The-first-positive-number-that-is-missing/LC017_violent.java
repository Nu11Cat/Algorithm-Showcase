class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 将所有正数存入集合
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        // 从1开始逐个检查最小缺失值
        int min = 1;
        while (set.contains(min)) {
            min++;
        }
        return min;
    }
}