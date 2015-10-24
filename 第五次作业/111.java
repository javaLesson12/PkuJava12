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
//…Ó∂»±È¿˙
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int ans=getDepth(root,1);
        return ans;
    }
    private int getDepth(TreeNode node,int d){
        if(node.left == null && node.right ==null){
            return d;
        }
        if(node.left == null)
            return getDepth(node.right,d+1);
        if(node.right == null)
            return getDepth(node.left,d+1);
        return Math.min(getDepth(node.left,d+1),getDepth(node.right,d+1));

    }
}