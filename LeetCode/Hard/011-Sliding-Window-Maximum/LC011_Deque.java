class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[n+1-k];
        for(int i = 0; i < n;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            deque.offerLast(i);
            if(deque.peekFirst()<=i-k) deque.removeFirst();
            if(i>=k-1) arr[i-k+1] = nums[deque.peekFirst()];
        }
        return arr;
    }
}