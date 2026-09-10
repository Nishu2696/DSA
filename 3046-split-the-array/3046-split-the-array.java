class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];

        for (int num: nums) {
            if (freq[num] == 2) return false;
            freq[num]++;
        }

        return true;

    }
}