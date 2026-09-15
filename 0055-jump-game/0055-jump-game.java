class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > maxReach) return false; // once index crosses maxReach, then there is no possibility of reaching or crossing from that index hence we are returnning false

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= n - 1) return true;
        }

        return false;
    }
}