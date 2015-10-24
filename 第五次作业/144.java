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
    public List<Integer> preorderTraversal(TreeNode root) {
        //        µÝ¹é
//        List<Integer> ans = new ArrayList<>();
//        if(root == null)
//            return ans;
//        visitedPoint(root, ans);
//        return ans;
//        ·ÇµÝ¹é
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        TreeNode visited;
        while (!stack.isEmpty()||p != null){
            if(p!=null){
                ans.add(p.val);
                stack.push(p);
                p=p.left;
            }else {
                p=stack.pop();
                p=p.right;
            }
        }
        return  ans;
    }

    public void visitedPoint(TreeNode p, List<Integer> list) {
        list.add(p.val);
        if (p.left != null)
            visitedPoint(p.left, list);
        if (p.right != null)
            visitedPoint(p.right, list);
    }
}