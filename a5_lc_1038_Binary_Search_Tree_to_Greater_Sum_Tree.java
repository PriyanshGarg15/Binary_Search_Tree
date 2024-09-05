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
    public int sum = 0; 
    
    public TreeNode bstToGst(TreeNode root) {
        reverseInOrderTraversal(root);
        return root;
    }
    
    public void reverseInOrderTraversal(TreeNode node) {
        if (node == null) return;
        

        reverseInOrderTraversal(node.right);
        
        sum += node.val;
        node.val = sum;

        reverseInOrderTraversal(node.left);
    }
}