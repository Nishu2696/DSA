class Solution {
    public int[] singleNumber(int[] nums) {
        int result = 0;

        for (int num: nums) {
            result = result ^ num;
        }

        int output = result & -result;

        int[] answer = new int[] {0, 0};

        for (int num: nums) {
            if ((output & num) == 0) {
                answer[0] = answer[0] ^ num;
            } else {
                answer[1] = answer[1] ^ num;
            }
        }

        return answer;
    }
}