/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return root;
               TreeNode p = root;
            TreeNode leftChild = p.left;
            p.left = p.right;
            p.right = leftChild;
            invertTree(p.left);
            invertTree(p.right);
            return p;
        }
}