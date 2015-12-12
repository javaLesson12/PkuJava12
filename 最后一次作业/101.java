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
       public boolean isSymmetric(TreeNode root) {
            return midSearchLeft(root).equals(midSearchRight(root));
        }
        public String midSearchLeft(TreeNode p) {
            if (p == null)
                return "#";
            String str = "";
            str += p.val;
            str += midSearchLeft(p.left);
            str += midSearchLeft(p.right);
            return str;
        }


        private String midSearchRight(TreeNode p) {
            if (p == null)
                return "#";
            String str = "";
            str += p.val;
            str += midSearchRight(p.right);
            str += midSearchRight(p.left);
            return str;
        }
}