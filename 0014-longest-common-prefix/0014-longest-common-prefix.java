class Solution {
    public String longestCommonPrefix(String[] strs) {
        // brute force approach

        // StringBuilder answer = new StringBuilder();
        // Arrays.sort(strs);
        // String first = strs[0];
        // String last = strs[strs.length - 1];

        // for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
        //     if (first.charAt(i) != last.charAt(i)) {
        //         return answer.toString();
        //     }
        //     answer.append(first.charAt(i));
        // }
        // return answer.toString();

        // better approach

        int minValue = Integer.MAX_VALUE;
        String s = "";
        for (String p: strs) {
            if (minValue > p.length()) {
                s = p;
            }
        }
        while (s.length() > 0) {
            if (isPrefix(s, strs)) {
                return s;
            } else {
                s = s.substring(0, s.length() - 1);
            }
        }

        return "";
    }

    public boolean isPrefix(String s, String[] strs) {
        for (String p: strs) {
            if (!p.startsWith(s)) {
                return false;
            }
        }
        return true;
    }
}