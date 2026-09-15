class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int count = 0;

        for (int num: arr1) {
            boolean flag = true;
            for (int num1: arr2) {
                int diff = Math.abs(num - num1);
                if (diff <= d) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        return count;
    }
}