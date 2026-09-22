class Solution {
    public boolean judgeSquareSum(int c) {
        long low = 0;
        long high = (long) Math.sqrt(c);

        while (low <= high) {

            long a = low * low;
            long b = high * high;

            long sum = a + b;

            if (sum == c) {
                return true;
            }else if (sum > c) {
                high = high - 1;
            } else {
                low = low + 1;
            }
        }

        return false;
    }
}