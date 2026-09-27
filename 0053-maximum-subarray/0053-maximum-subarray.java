class Solution {
    public int maxSubArray(int[] nums) {
        int total = 0;
        int res = nums[0];

        for(int i = 0; i < nums.length; i++) {
            if (total < 0) {
                total = 0;
            }
            total = total + nums[i];
            if (total > res) {
                res = total;
            }
        }

        // int max_sum = Integer.MIN_VALUE;
        // if (res == 0) {
        //     for (int i = 0; i < nums.length; i++) {
        //         if (nums[i] > max_sum) {
        //             max_sum = nums[i];
        //         }
        //     }
        //     res = max_sum;
        // }
        return res;
    }
}