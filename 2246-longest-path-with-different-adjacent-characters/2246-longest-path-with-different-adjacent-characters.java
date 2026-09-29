class Solution {
    int res = 0;
    List<Integer>[] children;
    public int longestPath(int[] parent, String s) {
        children = new ArrayList[parent.length];
        for (int i = 0; i < parent.length; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < parent.length; i++) {
            children[parent[i]].add(i);
        }
        dfs(s, 0);
        return res;
    }

    public int dfs(String s, int ind) {
        int longest = 0;
        int secondLongest = 0;

        for (int child: children[ind]) {
            int length = dfs(s, child);
            if (s.charAt(ind) == s.charAt(child)) {
                continue;
            }

            if (length > longest) {
                secondLongest = longest;
                longest = length;
            } else if (length > secondLongest) {
                secondLongest = length;
            }
        }

        res = Math.max(res, longest + secondLongest + 1);
        return longest + 1;
    }
}