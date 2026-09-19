class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> output = new ArrayList<>();
        char[] ch = digits.toCharArray(); // ['2', '3']
        StringBuilder str = new StringBuilder();
        helper(ch, map, 0, str, output);

        return output;
    }
    public void helper(char[] ch, HashMap<Character, String> map, int index, StringBuilder str, List<String> output) {
        // base condition
        if (index == ch.length) {
            output.add(str.toString());
            return;
        }

        // for (int i = 0; i < ch.length; i++) {
            String value = map.get(ch[index]);
            for (char ch1: value.toCharArray()) {
                str.append(ch1);
                helper(ch, map, index + 1, str, output);
                str.deleteCharAt(str.length() - 1);
            }
        // }
    }
}