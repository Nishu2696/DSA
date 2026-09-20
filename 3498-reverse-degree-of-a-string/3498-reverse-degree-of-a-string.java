class Solution {
    public int reverseDegree(String s) {
        int product = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            int value = 26 - (ch1 - 'a');
            product = product + (value * (i + 1));
        }

        return product;
    }
}