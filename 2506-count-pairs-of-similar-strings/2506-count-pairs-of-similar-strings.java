class Solution {
    public int similarPairs(String[] words) {
        Map<Set<Character>, Integer> map = new HashMap<>();

        for (String str: words) {
            Set<Character> set = new HashSet<>();
            for (char ch: str.toCharArray()) {
                set.add(ch);
            }
            map.put(set, map.getOrDefault(set, 0) + 1);
        }

        int result = 0;

        for (int value: map.values()) {
            result = result + ((value * (value - 1)) / 2) ;
        }

        return result;
    }
}