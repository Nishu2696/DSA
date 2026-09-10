class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key: map.keySet()) {
            if (map.get(key) > 2) {
                return false;
            }
        }

        return true;

    }
}