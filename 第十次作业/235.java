/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q)
            return root;
        if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//                        Stack[] stacks = findRoute(root,p,q);
//                        TreeNode nearSameNode = root;
//                        for(int i =0 ;i<stacks[0].size()&&i<stacks[1].size();++i){
//                            if (stacks[0].get(i) == stacks[1].get(i)){
//                                nearSameNode = (TreeNode) stacks[0].get(i);
//                            }
//                            else {
//                                break;
//                            }
//                        }
//                        return nearSameNode;
//        }
//
//        public Stack[] findRoute(TreeNode root, TreeNode p, TreeNode q) {
//            Stack<TreeNode> stack = new Stack<>();
//            stack.push(root);
//            TreeNode currentP = root.left;
//            TreeNode visitedP = null;
//            Stack<TreeNode> stack1 = new Stack<>();
//            Stack<TreeNode> stack2 = new Stack<>();
//            int flag = 0;
//            while (!stack.isEmpty() || currentP != null) {
//                if (currentP != null) {
//                    stack.push(currentP);
//                    if (currentP == p){
//                        stack1.addAll(stack);
//                        flag+=1;
//                        if (flag==2)
//                            break;
//                    }else if (currentP  == q){
//                        stack2.addAll(stack);
//                        flag+=1;
//                        if (flag==2)
//                            break;
//                    }
//                    currentP = currentP.left;
//
//                }else {
//                    TreeNode top =stack.peek();
//                    if (top.right!=null&&top.right!=visitedP){
//                        currentP = top.right;
//
//                    }else{
//                        stack.pop();
//                        visitedP = top;
//                    }
//                }
//            }
//            Stack[] stacks = new Stack[]{stack1,stack2};
//            return stacks;
//
//        }
}