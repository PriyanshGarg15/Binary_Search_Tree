import java.util.ArrayList;
import java.util.List;

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
    public void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }
    public TreeNode sortedArrayToBST(List<Integer> values, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = sortedArrayToBST(values, lo, mid - 1);
        root.right = sortedArrayToBST(values, mid + 1, hi);
        
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        return sortedArrayToBST(values, 0, values.size() - 1);
    }
}
