// brute force method
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
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        // Brute-force validation: check if the current node breaks the structural bounds
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively pass the restricted ranges down to the left and right subtrees
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
