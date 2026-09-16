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
    int minValue = Integer.MAX_VALUE;
    int prevValue = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inOrderTraversal(root);
        return minValue;
    }
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        minValue = Math.min(minValue, Math.abs(root.val - prevValue));
        prevValue = root.val;
        inOrderTraversal(root.right);
    }
}