/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        createGraph(root);

        int time = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int value = queue.poll();

                set.add(value);

                if (map.containsKey(value)) {
                    for (int neighbour: map.get(value)) {
                        if (!set.contains(neighbour)) {
                            queue.offer(neighbour);
                        }
                    }
                }
            }
        }

        return time;
    }
    public void createGraph(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            map.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
            map.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
        }

        if (root.right != null) {
            map.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
            map.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
        }

        createGraph(root.left);
        createGraph(root.right);
    }
}