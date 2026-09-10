class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int answer = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum)) {
                int last = map.get(sum);
                answer = Math.max(answer, i - last);
            } else {
                map.put(sum, i);
            }
        }

        return answer;
    }
}