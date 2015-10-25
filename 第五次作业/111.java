public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){     
            return 0;  
        }
        
        int left = minDepth(root.left);  
        int right = minDepth(root.right);  
        else if(left == 0 && right ==0){    
            return 1;  
        }
        else if(left == 0) 
            left = Integer.MAX_VALUE;  
        else if(right == 0) 
            right = Integer.MAX_VALUE;  
        return Math.min(left, right)+1;  
    }
}

//由于收到104题maxDepth的影响，内心就只有那么一个思路。然后就是一直显示错误！呵呵哒~