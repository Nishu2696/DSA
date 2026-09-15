class Solution {
    public int hIndex(int[] citations) {
        // [0, 1, 3, 5, 6]
        Arrays.sort(citations);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < citations.length; i++) {
            int value = citations[i];
            int count = citations.length - i;

            result = Math.max(result, Math.min(value, count));
        }

        return result == Integer.MIN_VALUE ? 0 : result;
    }
}