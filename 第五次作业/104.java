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
        int depth =0;
        if (root ==null){
            return 0;
        }
        else {
//            int depth =0;
            depth++;
            int i=maxDepth(root.left);
            int r=maxDepth(root.right);
            if( i>r){
                depth =depth +i;
            }
            else {
                depth =depth +r;
            }
        }
        return depth;
    }
}