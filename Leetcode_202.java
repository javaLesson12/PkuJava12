public class Solution {
    //尝试了多个数，凡是无限循环的，这个循环数列肯定包含145。
    public boolean isHappy(int n) {
        if (n == 1) return true;
        if (n == 0) return false;
        int on = n;
        int i=0;
        while (true) {
            int ans = 0;
            while (n > 0) {
                ans += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (ans == 4 || ans == 16 || ans == 20 || 
                ans == 37 || ans == 42 || ans == 58 || 
                ans == 89 || ans == 145) {//等于4，16，20，37，42，58，89，145，必是
                return false;
            } else if (ans == 1) {
                return true;
            }
            n=ans;
        }
    }
}