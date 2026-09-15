class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int maxReach = 0;

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) { // we are going till n - 1, because we dont need to jump from last index, we need to reach last index
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currEnd) { // every time we match currEnd, which is like a jump from previous step, we are again taking a jump from this index, hence this code
                jumps++;
                currEnd = maxReach;
            }
        }

        return jumps;
    }
}