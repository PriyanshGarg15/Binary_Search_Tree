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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } 
        // Element found
        else {
            // No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // One child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Two children
            else {
                // Find the maximum value in the left subtree
                int lmax = max(root.left);
                // Replace the root's value with the maximum value from the left subtree
                root.val = lmax;
                // Delete the maximum value node from the left subtree
                root.left = deleteNode(root.left, lmax);
            }
        }

        return root;
    }

    // Helper method to find the maximum value in a subtree
    public int max(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
