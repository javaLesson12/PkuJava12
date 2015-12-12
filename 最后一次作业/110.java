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
     public boolean isBalanced(TreeNode root) {

            return treeLength(root, 0) != -1;
        }
        public int treeLength(TreeNode p,int len){
            if (p==null)
                return len;
            int leftLen = treeLength(p.left,len+1);
            int rigthLen = treeLength(p.right,len+1);
            if (leftLen == -1 ||rigthLen == -1||Math.abs(leftLen-rigthLen)>1){
                return -1;
            }else {
                return Math.max(leftLen,rigthLen);
            }
        }
}