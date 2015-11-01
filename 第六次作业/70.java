public class Solution {
    public int climbStairs(int n) {
        if(n<0)
        return 0;
        if(n==0||n==1)
        return 1;
//        if(n==1||n==2)
//        return n;
        else
        return climbStairs(n - 1) + climbStairs(n - 2); 
    }
}