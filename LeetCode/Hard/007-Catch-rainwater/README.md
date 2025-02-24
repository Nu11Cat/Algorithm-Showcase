# [42. 接雨水] 
## (https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked)

#### **标签** 数组 |  双指针 | 栈 | 动态规划 | 单调栈


### 问题描述
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。


### 解法分析（详细注释见Java文件）

### 方法1 按照行求（超时）

按照行求，遍历每个位置，如果当前的高度小于i，并且两边有高度大于等于i的，说明这个地方一定有水，水就可以加1。
**时间复杂度**: O(n*m) 最大的数是m
**空间复杂度**: O(1)
```java
public int trap(int[] height) {
    int sum = 0;
    int max = getMax(height);//找到最大的高度，以便遍历。
    for (int i = 1; i <= max; i++) {
        boolean isStart = false; //标记是否开始更新 temp
        int temp_sum = 0;
        for (int j = 0; j < height.length; j++) {
            if (isStart && height[j] < i) {
                temp_sum++;
            }
            if (height[j] >= i) {
                sum = sum + temp_sum;
                temp_sum = 0;
                isStart = true;
            }
        }
    }
    return sum;
}
private int getMax(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
			}
		}
		return max;
}
```

### 方法2 按列求（超时）

遍历每一列，然后分别求出这一列两边最高的墙。找出较矮的一端，和当前列的高度比较，如果比当前列高，那么高出的值就是水。
**时间复杂度**: O(n*2)
**空间复杂度**: O(1)
```java
class Solution {
    public int trap(int[] height) {
        int sum=0;
        for(int i = 1; i < height.length - 1; i++){
            int leftmax=0;
            for(int j = 0; j < i; j++){
                if(height[j] > leftmax) leftmax = height[j];
            }
            int rightmax=0;
            for(int j = i + 1; j < height.length; j++){
                if(height[j] > rightmax) rightmax = height[j];
            }
            int min=Math.min(rightmax,leftmax);
            if(height[i] < min) sum += min - height[i];
        }
        return sum;
    }
}
```

### 方法3 动态规划

实际上是对方法二的升级
用两个数组，max_left [i]代表第i列左边最高的墙的高度，max_right[i]代表第i列右边最高的墙的高度。
**时间复杂度**: O(n)
**空间复杂度**: O(n)
```java
class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int sum = 0;
        for(int i = 1; i < height.length-1; i++){
            left[i] = Math.max(left[i - 1],height[i - 1]);
        }
        for(int i = height.length-2 ; i >= 0; i--){
            right[i] = Math.max(right[i + 1],height[i + 1]);
        }
        for(int i = 1; i < height.length - 1; i++){
            int min=Math.min(right[i],left[i]);
            if(height[i] < min) sum += min - height[i];
        }
        return sum;
    }
}
```


### 方法4 双指针

实际上是对方法三的升级
优化动态规划的空间
**时间复杂度**: O(n)
**空间复杂度**: O(1)
```java
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int preMax = 0; // 前缀最大值，随着左指针 left 的移动而更新
        int sufMax = 0; // 后缀最大值，随着右指针 right 的移动而更新
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            ans += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
        }
        return ans;
    }
}

```
### 方法4 双指针

**时间复杂度**: O(n)
**空间复杂度**: O(min(n,U))，其中U=max(height)−min(height)+1。
```java
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[i] >= height[st.peek()]) {
                int bottomH = height[st.pop()];
                if (st.isEmpty()) {
                    break;
                }
                int left = st.peek();
                int dh = Math.min(height[left], height[i]) - bottomH; // 面积的高
                ans += dh * (i - left - 1);
            }
            st.push(i);
        }
        return ans;
    }
}
```

### 比较与总结
解法二到解法三，利用动态规划，空间换时间，解法三到解法四，优化动态规划的空间


### 特殊处理
此题目无特殊处理
