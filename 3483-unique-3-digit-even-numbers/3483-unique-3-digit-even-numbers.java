class Solution {
    public int totalNumbers(int[] digits) {
        Arrays.sort(digits);
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[digits.length];
        helper(digits, set, 0, visited);

        return set.size();
    }
    public void helper(int[] digits, Set<Integer> set, int number, boolean[] visited) {
        if (number >= 100 ) {
            if (number % 2 == 0) {
                set.add(number);
            }
            return;
            }

        for (int i = 0; i < digits.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && digits[i] == digits[i - 1] && !visited[i - 1]) continue;

            if (number == 0 && digits[i] == 0) {
                continue;
            }

            visited[i] = true;
            number = number * 10 + digits[i];
            helper(digits, set, number, visited);
            visited[i] = false;
            number = number / 10;
        }
    }
}