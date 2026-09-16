/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return helper(original, cloned, target);
    }
    public final TreeNode helper (final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null && cloned == null) return null;

        if (original.val == target.val && cloned.val == target.val) {
            return cloned;
        }

        TreeNode result = helper(original.left, cloned.left, target);

        if (result != null && cloned.left != null) {
            return result;
        }

        return helper(original.right, cloned.right, target);
    }
}