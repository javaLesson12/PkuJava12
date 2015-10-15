/*
	Maximum Depth of Binary Tree
	Given a binary tree, find its maximum depth.
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	
     Definition for a binary tree node. 
*/
  class TreeNode 
  {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

class Test104 
{
	public static void main(String[] args) 
	{
		
	}
	public int maxDepth(TreeNode root) 
    {
       
	   if(root==null)
		   return 0;
	   int ldepth= maxDepth(root.left);
	   int rdepth= maxDepth(root.right);
	   return ldepth>rdepth?ldepth+1:rdepth+1;    
    }


}
