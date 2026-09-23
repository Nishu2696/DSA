class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> answer = new ArrayList<>();
        int left = 0;
        int right = n - 1;

        while (right - left + 1 > k) {
            int rightValue = arr[right] - x;
            int leftValue = x - arr[left];

            if (rightValue < leftValue) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            answer.add(arr[i]);
        }
        return answer;
    }
}