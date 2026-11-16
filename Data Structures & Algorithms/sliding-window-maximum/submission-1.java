class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) 
                q.pollFirst();
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) 
                q.pollLast(); 
            q.offerLast(i);           
            if (i >= k - 1) 
                res[i - k + 1] = nums[q.peekFirst()];
        }
        return res;
    }
}
