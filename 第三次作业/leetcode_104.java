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
  public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return getMaxDepth(root, 1);
    }

    private int getMaxDepth(TreeNode root, int i) {
        if (root.left == null && root.right == null)
            return i;
        int lh=i;
        if(root.left!=null){
            lh=getMaxDepth(root.left, i + 1);
        }
        int rh=i;
        if(root.right!=null){
            rh=getMaxDepth(root.right, i + 1);
        }
        return Math.max(lh,rh);
    }
}