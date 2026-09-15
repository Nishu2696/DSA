class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        for (int num: citations) {
            if (num >= n) {
                count[n]++;
            } else {
                count[num]++;
            }
        }

        int result = 0;

        for (int h = n; h >= 0; h--) {
            result = result + count[h];
            if (result >= h) {
                return h;
            } 
        }

        return 0;
    }
}