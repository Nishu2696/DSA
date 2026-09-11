class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, list, new ArrayList<>());

        int sum = 0;

        for (List<Integer> ans: list) {
            int answer = 0;
            for (int num: ans) {
                answer = answer ^ num;
            }
            sum = sum + answer;
        }

        return sum;
    }
    public void helper(int[] nums, int index, List<List<Integer>> list, List<Integer> result) {
        if (index == nums.length) return;
        result.add(nums[index]);
        list.add(new ArrayList<>(result));
        helper(nums, index + 1, list, result);
        result.remove(result.size() - 1);
        helper(nums, index + 1, list, result);
    }
}