public class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int m00 = 0, m01 = 1, m10 = 1, m11 = 1;
        int rsm00 = 0, rsm01 = 1, rsm10 = 1, rsm11 = 1;
        for (int i = 1; i < n-1; i++) {
            int tmp00 = rsm00, tmp01 = rsm01, tmp10 = rsm10, tmp11 = rsm11;
            rsm00 = m00 * tmp00 + m01 * tmp10;
            rsm01 = m00 * tmp01 + m01 * tmp11;
            rsm10 = m10 * tmp00 + m11 * tmp10;
            rsm11 = m10 * tmp01 + m11 * tmp11;
        }
        return rsm11 + rsm10;
    }
}