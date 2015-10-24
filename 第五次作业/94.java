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
      public List<Integer> inorderTraversal(TreeNode root) {
//        µÝ¹é
//        List<Integer> ans = new ArrayList<>();
//        if(root == null)
//            return ans;
//        visitedPoint(root, ans);
//        return ans;
//        ·ÇµÝ¹é
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        Set<TreeNode> visitedNodes=new HashSet<>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                if (!visitedNodes.contains(p))
                {
                    ans.add(p.val);
                    visitedNodes.add(p);
                    if(p.right!=null&&!visitedNodes.contains(p.right))
                    {
                        p = p.right;
                    }
                    else {
                        p=null;
                    }
                }else {
                    stack.pop();
                    p=null;
                }

            }
        }
        return ans;
    }

    public void visitedPoint(TreeNode p, List<Integer> list) {

        if (p.left != null)
            visitedPoint(p.left, list);
        list.add(p.val);
        if (p.right != null)
            visitedPoint(p.right, list);
    }
}